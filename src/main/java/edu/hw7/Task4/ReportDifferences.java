package edu.hw7.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.hw7.Task4.MultiThread.multiThreadPiCount;
import static edu.hw7.Task4.SingleThread.singleThreadPiCount;

public class ReportDifferences {

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws InterruptedException {
        int iterationsCount = 100000;
        LOGGER.info("Differences between SingleThread and MultiThread(MT) methods" + "\n");
        for (int i = 1; i < 5; i++) {
            LOGGER.info("IterationsCount: " + iterationsCount + " ThreadsCount: " + i + "\n");
            LOGGER.info("MT is faster by " + executionTime(iterationsCount, i) / executionTime(iterationsCount) + "\n");
            iterationsCount = iterationsCount * 10;
        }

    }

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
}
