package edu.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task4Test {

    @ParameterizedTest
    @CsvSource({"2, II", "12, XII", "16, XVI", "4, IV", "9, IX", "3999, MMMCMXCIX"})
    void convertToRoman_BaseCases_Test(int input, String expected) {
        var result = Task4.convertToRoman(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void convertToRoman_InputLessOrEqualToZero_ThrowException_Test() {
        int result = 0;

        Assertions.assertThrows(NumberFormatException.class, () ->
            Task4.convertToRoman(result)
        );
    }

    @Test
    void convertToRoman_InputGreater3999_ThrowException_Test() {
        int result = 4000;

        Assertions.assertThrows(NumberFormatException.class, () ->
            Task4.convertToRoman(result)
        );
    }
}
