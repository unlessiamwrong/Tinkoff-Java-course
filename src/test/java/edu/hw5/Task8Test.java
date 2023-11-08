package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @ParameterizedTest
    @CsvSource({"0,true", "110,true", "11,false", "0000,false"})
    public void oddLength_Test(String input, boolean expected) {
        assertThat(Task8.regex1(input)).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"0,true", "11,true", "010,true", "01,false", "110,false"})
    public void startsWithZero_HasOddLength_Or_startsWithOne_HasEvenLength_Test(String input, boolean expected) {
        assertThat(Task8.regex2(input)).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"0,true", "1111,true", "101,true", "11,false", "111,false"})
    public void except_TwoOnes_or_ThreeOnes(String input, boolean expected) {
        assertThat(Task8.regex4(input)).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"0,true", "101,true", "1001,true", "11,false", "1011,false"})
    public void no_Consecutive_Ones(String input, boolean expected) {
        assertThat(Task8.regex8(input)).isEqualTo(expected);

    }
}
