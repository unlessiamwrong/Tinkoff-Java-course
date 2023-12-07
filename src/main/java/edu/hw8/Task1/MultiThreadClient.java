package edu.hw8.Task1;

public class MultiThreadClient {

    private final int port;
    private final int threadsCount;

    public MultiThreadClient(int port, int threadsCount) {
        this.port = port;
        this.threadsCount = threadsCount;
    }

    public void multiThreadRun() throws InterruptedException {
        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = run();
        }
        joinAllThreads(threads);
    }

    private Thread run() {
        Client client = new Client(port);
        Thread thread = new Thread(client::clientRun);
        thread.start();
        return thread;

    }

    private void joinAllThreads(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
