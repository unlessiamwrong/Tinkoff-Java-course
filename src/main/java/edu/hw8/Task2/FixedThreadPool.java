package edu.hw8.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FixedThreadPool implements ThreadPool {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Thread[] threads;
    private final long[] results;

    public FixedThreadPool(int threadCount) {
        threads = new Thread[threadCount];
        results = new long[threadCount];
    }

    private static long fib(long n) {
        if (n <= 1) {
            return n;
        }
        long first = 0L;
        long second = 1L;
        for (int i = 2; i <= n; i++) {
            long summary = first + second;
            first = second;
            second = summary;
        }
        return second;
    }

    @Override
    public void start() {
        for (int i = 0; i < threads.length; i++) {
            final int current = i;
            threads[i] = new Thread(() -> {
                long result = fib(current);
                results[current] = result;
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        start();
        close();
    }

    @Override
    public void close() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
            LOGGER.info(threads[i].getName() + ": " + results[i]);
        }

    }
}
