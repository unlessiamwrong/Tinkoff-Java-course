package edu.hw8.Task3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HackMultiThread {

    private static final int PASSWORD_GENERATION_LENGTH = 4;
    private static final Logger LOGGER = LogManager.getLogger();
    private final ConcurrentHashMap<String, String> passwords = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, String> result = new ConcurrentHashMap<>(); // made public for tests
    private final Thread[] threads;

    public HackMultiThread(Map<String, String> map, int threadsCount) {
        threads = new Thread[threadsCount];
        for (String key : map.keySet()) {
            passwords.put(map.get(key), key);
        }
    }

    private void multiThread() throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = decryptPassword();
        }
        for (Thread thread : threads) {
            thread.join();
        }

    }

    private Thread decryptPassword() {
        Thread thread = new Thread(() -> {
            while (!passwords.isEmpty()) {
                String random = RandomStringUtils.randomAlphanumeric(PASSWORD_GENERATION_LENGTH).toLowerCase();
                String randomHash = Md5Hash.get(random);
                String possibleUser = passwords.get(randomHash);
                if (possibleUser != null) {
                    result.put(possibleUser, random);
                    passwords.remove(randomHash);
                }
            }
        });
        thread.start();
        return thread;
    }

    public void run() throws InterruptedException {
        multiThread();
        LOGGER.info(result);
    }

}
