package edu.hw8.Task1;

public class MultiThreadClient {

    private MultiThreadClient() {

    }

    public static void multiThreadRun(int port, int threadsCount) throws InterruptedException {
        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = run(port);
        }
        joinAllThreads(threads);
    }

    private static Thread run(int port) {
        Thread thread = new Thread(() ->
            Client.clientRun(port)
        );
        thread.start();
        return thread;

    }

    private static void joinAllThreads(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
