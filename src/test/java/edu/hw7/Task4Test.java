package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task4.MultiThread.multiThreadPiCount;
import static edu.hw7.Task4.SingleThread.singleThreadPiCount;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    private static float executionTime(int totalCount) {
        long startTime = System.nanoTime();
        singleThreadPiCount(totalCount);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static float executionTime(int totalCount, int threadsCount) throws InterruptedException {
        long startTime = System.nanoTime();
        multiThreadPiCount(totalCount, threadsCount);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    @Test
    void multiThread_AlwaysFaster_SingleThread_Test() throws InterruptedException {
        //Arrange
        int[] iterations = new int[] {1000000, 10000000, 100000000, 1000000000};
        int threadsCount = 4;

        //Act
        double expected = 0.0;
        for (int iteration : iterations) {
            expected += (executionTime(iteration) - executionTime(iteration, threadsCount));
        }

        //Assert
        assertThat(expected).isGreaterThanOrEqualTo(0.0);

    }
}
