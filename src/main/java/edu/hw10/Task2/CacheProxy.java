package edu.hw10.Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class CacheProxy implements InvocationHandler {

    private final Object target;
    private final ConcurrentHashMap<String, Long> cache;

    private final ConcurrentHashMap<Method, Boolean> annotationCache;

    private final File file;

    public CacheProxy(Object target, File file) {
        this.target = target;
        this.cache = new ConcurrentHashMap<>();
        this.annotationCache = new ConcurrentHashMap<>();
        this.file = file;
    }

    public static <T> T create(T target, Class<T> targetInterface, File file) {
        return targetInterface.cast(Proxy.newProxyInstance(
            targetInterface.getClassLoader(),
            new Class<?>[] { targetInterface },
            new CacheProxy(target, file)
        ));
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (isMethodCacheable(method)) {
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

    private boolean isMethodCacheable(Method method) {
        return annotationCache.computeIfAbsent(method, m -> m.isAnnotationPresent(Cache.class));
    }

    private void saveCache() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print(cache);
        out.print("\n");
        out.close();
    }
}
