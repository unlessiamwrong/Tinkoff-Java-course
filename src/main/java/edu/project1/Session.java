package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.project1.ConsoleHangman.maskedWord;
import static edu.project1.ConsoleHangman.maxAttempts;

@SuppressWarnings("ReturnCount")
public final class Session {

    private final static Logger LOGGER = LogManager.getLogger();
    static boolean gameOver = false;
    public static int attempts;

    private Session() {
    }

    public static void giveUp() {
        gameOver = true;
    }

    public static void guess(String word, char letter) {
        int index = word.indexOf(letter);
        if (index == -1) {
            attempts++;
            if (attempts == maxAttempts) {
                LOGGER.info("You lose. Better luck next time!");
                LOGGER.info("The word: " + maskedWord);
                gameOver = true;
                return;
            }
            LOGGER.info("Missed! Attempts: " + attempts + "/" + maxAttempts);
            return;
        }
        LOGGER.info("Hit! Good job!");
        char[] wordChars = maskedWord.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == letter) {
                wordChars[i] = letter;
            }
        }
        maskedWord = String.valueOf(wordChars);
        if (maskedWord.equals(word)) {
            LOGGER.info("YOU WIN!");
            LOGGER.info("The word was: " + word);
            gameOver = true;
        }
    }
}

