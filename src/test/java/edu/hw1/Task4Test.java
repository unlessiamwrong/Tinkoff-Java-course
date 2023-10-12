package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Fix the string")
    void simpleFixTest() {
        String string;
        String fixedString;

        string = "123456";
        fixedString = Task4.fixString(string);

        assertThat(fixedString).isEqualTo("214365");

        string = "hTsii  s aimex dpus rtni.g";
        fixedString = Task4.fixString(string);

        assertThat(fixedString).isEqualTo("This is a mixed up string.");

        string = "badce";
        fixedString = Task4.fixString(string);

        assertThat(fixedString).isEqualTo("abcde");

        string = "11112";
        fixedString = Task4.fixString(string);

        assertThat(fixedString).isEqualTo("11112");

        string = "111112";
        fixedString = Task4.fixString(string);

        assertThat(fixedString).isEqualTo("111121");
    }
}
