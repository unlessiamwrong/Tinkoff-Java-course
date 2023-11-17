package edu.hw6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("RegexpSinglelineJava")
public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {

    }

    public static void writeKey(String fileName, String key, String value) {
        File file = new File(fileName);
        try (FileOutputStream out = new FileOutputStream(file, true)) {
            String text = key + ":" + value + "\r\n";
            out.write(text.getBytes());
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }

    }

    public static void readKey(String fileName) {
        try (FileInputStream in = new FileInputStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}

