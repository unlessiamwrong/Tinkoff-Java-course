package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("MagicNumber")
public class MultiThread {

    private MultiThread() {

    }

    public static double multiThreadPiCount(int totalCount, int threadsCount) throws InterruptedException {
        AtomicInteger circleCount = new AtomicInteger(0);
        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = piCount(totalCount, circleCount, threadsCount);
        }
        joinAllThreads(threads);
        return 4 * ((double) circleCount.get() / totalCount);
    }

    private static Thread piCount(int totalCount, AtomicInteger circleCount, int threadsCount) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < (totalCount / threadsCount); i++) {
                double x = ThreadLocalRandom.current().nextDouble(0, 1);
                double y = ThreadLocalRandom.current().nextDouble(0, 1);
                if ((Math.pow(x, 2) + Math.pow(y, 2)) < 1) {
                    circleCount.getAndIncrement();
                }
            }
        });
        thread.start();
        return thread;
    }

    private static void joinAllThreads(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
