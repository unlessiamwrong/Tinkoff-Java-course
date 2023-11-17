package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    public static int parallelIncrement() throws InterruptedException {
        AtomicInteger value = new AtomicInteger(0);
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    value.incrementAndGet();

                }
            });
            thread.start();
            thread.join();

        }
        return value.get();
    }
}
