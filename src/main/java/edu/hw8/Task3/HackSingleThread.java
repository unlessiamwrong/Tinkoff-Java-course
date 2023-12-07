package edu.hw8.Task3;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HackSingleThread {

    private static final int PASSWORD_GENERATION_LENGTH = 4;
    private static final Logger LOGGER = LogManager.getLogger();
    public final HashMap<String, String> result = new HashMap<>(); // made public for tests
    private final HashMap<String, String> passwords = new HashMap<>();

    public HackSingleThread(Map<String, String> map) {
        for (String key : map.keySet()) {
            passwords.put(map.get(key), key);
        }
    }

    private void decryptPassword() {
        while (!passwords.isEmpty()) {
            String random = RandomStringUtils.randomAlphanumeric(PASSWORD_GENERATION_LENGTH).toLowerCase();
            Md5Hash md5Hash = new Md5Hash();
            String randomHash = md5Hash.get(random);
            String possibleUser = passwords.get(randomHash);
            if (possibleUser != null) {
                result.put(possibleUser, random);
                passwords.remove(randomHash);
            }
        }
    }

    public void run() {
        decryptPassword();
        LOGGER.info(result);
    }

}
