package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Check if number or its descendants are palindrome")
    void simpleCheckTest() throws Exception {
        int number;
        boolean result;

        number = 11211230;
        result = Task5.isPalindromeDescendant(number);

        assertThat(result).isTrue();

        number = 13001120;
        result = Task5.isPalindromeDescendant(number);

        assertThat(result).isTrue();

        number = 23336014;
        result = Task5.isPalindromeDescendant(number);

        assertThat(result).isTrue();

        number = 11;
        result = Task5.isPalindromeDescendant(number);

        assertThat(result).isTrue();

        number = 1;
        try {
            Task5.isPalindromeDescendant(number);
        } catch (Exception e) {
            // known exception
        }
        number = -1;
        try {
            Task5.isPalindromeDescendant(number);
        } catch (Exception e) {
            // known exception

        }

    }
}
