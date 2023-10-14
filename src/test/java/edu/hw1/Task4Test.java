package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @ParameterizedTest
    @CsvSource({"123456,214365", "hTsii  s aimex dpus rtni.g,This is a mixed up string.", "badce,abcde", "11112,11112",
        "111112,111121", ","})
    @DisplayName("Fix the string, basic cases")
    void fixString_BasicCases_Test(String input, String expected) {
        assertThat(Task4.fixString(input)).isEqualTo(expected);

    }
}
