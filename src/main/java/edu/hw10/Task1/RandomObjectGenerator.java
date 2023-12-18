package edu.hw10.Task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

@SuppressWarnings("MagicNumber")
public class RandomObjectGenerator {

    private final String generatedName = RandomStringUtils.randomAlphabetic(5);
    private final Random random = new Random();
    private String name;
    private int left = 0;
    private int right = 100;

    public <T> T nextObject(Class<T> cls)
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<T> constructor = cls.getConstructor(String.class, int.class);
        for (Field field : cls.getDeclaredFields()) {
            var fieldType = field.getType();
            if (field.isAnnotationPresent(NotNull.class) && fieldType == String.class) {
                name = generatedName;
            }
            if (field.isAnnotationPresent(Min.class) &&
                (Number.class.isAssignableFrom(fieldType) || fieldType.isPrimitive())) {
                Min minAnnotation = field.getAnnotation(Min.class);
                left = minAnnotation.value();
            }
            if (field.isAnnotationPresent(Max.class) &&
                (Number.class.isAssignableFrom(fieldType) || fieldType.isPrimitive())) {
                Max maxAnnotation = field.getAnnotation(Max.class);
                right = maxAnnotation.value();

            }
        }
        return constructor.newInstance(name, random.nextInt(left, right));
    }
}
