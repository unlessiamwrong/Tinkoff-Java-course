package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project1Test {

    @Test
    @DisplayName("Wrong input, game is not ending Test")
    public void consoleHangman_WrongInput_GameIsNotOver_Test() {
        //Arrange
        Session.gameOver = false;
        String word = ConsoleHangman.word;
        String userAnswer = "1";

        //Act
        ConsoleHangman.tryGuess(userAnswer, word);

        //Assert
        assertThat(Session.gameOver).isFalse();

    }

    @Test
    @DisplayName("Empty input, game is not ending Test")
    public void consoleHangman_EmptyInput_GameIsNotOver_Test() {
        //Arrange
        Session.gameOver = false;
        String word = ConsoleHangman.word;
        String userAnswer = "";

        //Act
        ConsoleHangman.tryGuess(userAnswer, word);

        //Assert
        assertThat(Session.gameOver).isTrue();

    }

    @Test
    @DisplayName("Wrong guess, attempts < maxAttempts, game is not ending Test")
    public void session_WrongGuessNotMaxAttempts_GameIsNotOver_Test() {
        //Arrange
        Session.gameOver = false;
        ConsoleHangman.maxAttempts = 3;
        Session.attempts = 1;
        String word = ConsoleHangman.word;
        char userAnswer = 'q';

        //Act
        Session.guess(word, userAnswer);

        //Assert
        assertThat(Session.gameOver).isFalse();

    }

    @Test
    @DisplayName("Wrong guess, attempts >= maxAttempts, game is not ending Test")
    public void session_WrongGuessMaxAttempts_GameIsOver_Test() {
        //Arrange
        Session.gameOver = false;
        ConsoleHangman.maxAttempts = 1;
        Session.attempts = 0;
        String word = ConsoleHangman.word;
        char userAnswer = 'z';

        //Act
        Session.guess(word, userAnswer);

        //Assert
        assertThat(Session.gameOver).isTrue();

    }

    @Test
    @DisplayName("Correct guess, word is not finished, game is not ending Test")
    public void session_CorrectGuessWordIsMasked_GameIsNotOver_Test() {
        //Arrange
        Session.gameOver = false;
        ConsoleHangman.maxAttempts = 3;
        Session.attempts = 1;
        String word = ConsoleHangman.word;
        char userAnswer = 'a';

        //Act
        Session.guess(word, userAnswer);

        //Assert
        assertThat(Session.gameOver).isFalse();

    }

    @Test
    @DisplayName("Correct guess, word is finished, game is ending Test")
    public void session_CorrectGuessWordIsUnmasked_GameIsOver_Test() {
        //Arrange
        String word = ConsoleHangman.word;
        ConsoleHangman.maskedWord = word;
        char userAnswer = 'a';

        //Act
        Session.guess(word, userAnswer);

        //Assert
        assertThat(Session.gameOver).isTrue();

    }
}
