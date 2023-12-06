package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task1.parallelIncrement;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void parallelIncrement_ReturnsRequired_Test() throws InterruptedException {
        //Arrange
        int result = 10000;

        //Act
        int summaryResults = 0;
        for (int i = 0; i < result; i++) {
            summaryResults += parallelIncrement(result);
        }

        //Assert
        assertThat(summaryResults / result).isEqualTo(result);
    }
}
