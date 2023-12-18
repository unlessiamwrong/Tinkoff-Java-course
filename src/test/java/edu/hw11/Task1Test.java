package edu.hw11;

import java.lang.reflect.InvocationTargetException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void task1() throws InstantiationException, IllegalAccessException, NoSuchMethodException,
        InvocationTargetException {

        //Arrange
        Class<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.named("toString"))
            .intercept(FixedValue.value("Hello World!"))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        //Act
        String result = dynamicType.getConstructor().newInstance().toString();

        //Assert
        assertThat(result).isEqualTo("Hello World!");
    }
}
