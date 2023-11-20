package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    private static final int THREADS_COUNT = 4;

    private Task1() {

    }

    public static int parallelIncrement(int requiredValue) throws InterruptedException {
        AtomicInteger currentValue = new AtomicInteger(0);
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = increment(currentValue, requiredValue, threads.length);
        }
        joinAllThreads(threads);
        return currentValue.get();
    }

    private static Thread increment(AtomicInteger currentValue, int requiredValue, int threadsLength) {
        Thread thread = new Thread(() -> {
            for (int j = 0; j < requiredValue / threadsLength; j++) {
                currentValue.incrementAndGet();

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
