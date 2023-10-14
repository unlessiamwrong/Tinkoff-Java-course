package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @ParameterizedTest
    @CsvSource({"5000,4", "500,3", "50,2", "5,1", "0,1", "-5,-1"})
    @DisplayName("Count digits amount from number, basic cases")
    void countDigits_BasicCases_Test(int input, int expected) {
        int result = Task2.countDigits(input);

        assertThat(result).isEqualTo(expected);

    }
}
