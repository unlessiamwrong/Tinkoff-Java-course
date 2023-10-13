package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @ParameterizedTest
    @CsvSource({"11211230,true", "13001120,true", "23336014,true", "11,true"})
    @DisplayName("Check if number or its descendants are palindrome")
    void isPalindromeDescendant_BasicCases_Test(int input, boolean expected) {
        assertThat(Task5.isPalindromeDescendant(input)).isEqualTo(expected);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, -1})
    @DisplayName("Check if number or its descendants are palindrome, expected Exceptions")
    void isPalindromeDescendant_WhenAmountOddOrIntNegative_ThrowsException_Test(int input) {

        Assertions.assertThrows(NumberFormatException.class, () -> {
            Task5.isPalindromeDescendant(input);

        });
    }
}

