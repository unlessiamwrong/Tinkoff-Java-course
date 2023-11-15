package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @ParameterizedTest
    @CsvSource({"000,true", "110,true", "1101,true", "00,false", "111,false"})
    public void atLeast3Symbols_ZeroIsThird_Test(String input, boolean expected) {
        assertThat(Task7.regex1(input)).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"000,true", "1101,true", "1,true", "01,false", "110,false"})
    public void starts_Ends_WithSameSymbol_Test(String input, boolean expected) {
        assertThat(Task7.regex2(input)).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"0,true", "11,true", "101,true", "0011,false", "11111,false"})
    public void length_Between_One_Three(String input, boolean expected) {
        assertThat(Task7.regex3(input)).isEqualTo(expected);

    }
}
