package edu.hw10.Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements InvocationHandler {

    private final Object target;
    private final Map<String, Long> cache;
    private final File file;

    public CacheProxy(Object target, File file) {
        this.target = target;
        this.cache = new HashMap<>();
        this.file = file;
    }

    public static <T> T create(T target, Class<? super T> targetInterface, File file) {
        return (T) Proxy.newProxyInstance(
            targetInterface.getClassLoader(),
            new Class<?>[] {targetInterface},
            new CacheProxy(target, file)
        );
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            String key = method.getName() + Arrays.toString(args);
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            Object result = method.invoke(target, args);
            cache.put(key, (long) result);
            saveCache();
            return result;
        } else {
            return method.invoke(target, args);
        }
    }

    private void saveCache() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print(cache);
        out.print("\n");
        out.close();
    }
}
