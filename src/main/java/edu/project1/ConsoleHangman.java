package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConsoleHangman {
    private final static Logger LOGGER = LogManager.getLogger();
    static String word = Dictionary.getWord();
    static int maxAttempts = word.length();
    static String maskedWord = "*".repeat(word.length());

    private ConsoleHangman() {
    }

    public static void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(Session.gameOver)) {
                LOGGER.info("The word: " + maskedWord);
                LOGGER.info("Guess a letter");
                String userAnswer = reader.readLine();
                tryGuess(userAnswer, word);
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    public static void tryGuess(String userAnswer, String word) {
        if (userAnswer.isEmpty()) {
            LOGGER.info("Giving up? Shame on you!");
            Session.giveUp();
            return;
        }
        char letter = userAnswer.charAt(0);
        if ((userAnswer.length() != 1) || Character.isDigit(letter)) {
            LOGGER.info("Please Enter a single letter");
        } else {
            Session.guess(word, letter);
        }

    }
}
