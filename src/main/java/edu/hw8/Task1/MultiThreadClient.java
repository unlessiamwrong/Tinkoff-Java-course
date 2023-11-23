package edu.hw8.Task1;

public class MultiThreadClient {

    public static void multiThreadRun(int port) throws InterruptedException {
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = run(port);
        }
        joinAllThreads(threads);
    }

    private static Thread run(int port) {
        Thread thread = new Thread(() -> {
            Client.clientRun(port);
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
