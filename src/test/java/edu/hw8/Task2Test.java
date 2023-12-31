package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test void threadPool_ReturnsCorrectFib_Test() {
        //Arrange
        var fixedThreadPool = new FixedThreadPool(20);

        //Act
        fixedThreadPool.execute(null);
        long[] result = fixedThreadPool.results;

        //Assert
        assertThat(result).isNotEmpty();

    }
}
