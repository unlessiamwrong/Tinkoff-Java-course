package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @ParameterizedTest
    @CsvSource({"6621,5", "6554,4", "1001,4"})
    @DisplayName("Count amount of steps to make Kaprekar's number, basic cases")
    void countK_BasicCases_Test(int input, int expected) {
        assertThat(Task6.countK(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Count amount of steps to make Kaprekar's number, expected Exception")
    void countK_IfIntLessThanRequired_ThrowsException_Test() {
        int input = 1000;
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Task6.countK(input);

        });
    }
}
