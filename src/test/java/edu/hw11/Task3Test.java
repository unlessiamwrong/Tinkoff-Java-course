package edu.hw11;

import edu.hw11.Task3.Fib;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void task3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Arrange
        Fib fib = new Fib();
        var cls = fib.generate();
        Method method = cls.getMethod("run", int.class);

        //Act
        var result = method.invoke(null, 10);

        //Assert
        assertThat(result).isEqualTo(55L);
    }
}
