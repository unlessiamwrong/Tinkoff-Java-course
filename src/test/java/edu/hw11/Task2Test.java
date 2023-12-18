package edu.hw11;

import edu.hw11.Task2.Multiply;
import edu.hw11.Task2.Summary;
import java.lang.reflect.InvocationTargetException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import org.junit.jupiter.api.Test;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void task2() throws NoSuchMethodException, InvocationTargetException, InstantiationException,
        IllegalAccessException {

        // Arrange
        Summary summary = new ByteBuddy()
            .subclass(Summary.class)
            .method(named("sum"))
            .intercept(MethodDelegation.to(new Multiply()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded()
            .getConstructor()
            .newInstance();

        //Act
        int result = summary.summary(2, 3);

        //Assert
        assertThat(result).isEqualTo(6);
    }
}
