package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({"00:25,25", "5:25,325", "100:25,6025", "0000,-1", "abcd,-1"})
    @DisplayName("Convert video length value from minutes to seconds, basic cases")
    void minutesToSeconds_BasicCases_Test(String input, int expected) {
        int seconds = Task1.minutesToSeconds(input);

        assertThat(seconds).isEqualTo(expected);

    }

    @Test
    @DisplayName("Convert video length value from minutes to seconds, expected Exceptions")
    void minutesToSeconds_WhenIntTooLarge_ThrowsException_Test() {
        String input = "12345678910";

        Assertions.assertThrows(NumberFormatException.class, () ->
            Task1.minutesToSeconds(input)

        );
    }
}
