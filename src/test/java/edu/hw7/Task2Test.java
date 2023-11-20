package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task2.parallelFactorial;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    void parallelFactorial_ReturnsRequired_Test() {
        //Arrange
        int value = 8;
        int result = 40320;

        //Act
        int summaryResults = 0;
        for (int i = 0; i < result; i++) {
            summaryResults += parallelFactorial(value);
        }

        //Assert
        assertThat(summaryResults / result).isEqualTo(result);
    }
}
