package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @ParameterizedTest
    @CsvSource({"abc,false", "abc*,true", "abc!*,true", "abc!!*,true", "*,true"})
    public void validatePassword_Test(String input, boolean expected) {
        assertThat(Task4.validatePassword(input)).isEqualTo(expected);

    }
}
