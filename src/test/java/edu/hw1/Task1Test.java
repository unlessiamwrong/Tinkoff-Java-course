package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Convert video length value from minutes to seconds")
    void simpleConvertTest() {
        int seconds;
        String minutes;

        minutes = "5:00";
        seconds = Task1.minutesToSeconds(minutes);

        assertThat(seconds).isEqualTo(300);

        minutes = "00:25";
        seconds = Task1.minutesToSeconds(minutes);

        assertThat(seconds).isEqualTo(25);

        minutes = "5:25";
        seconds = Task1.minutesToSeconds(minutes);

        assertThat(seconds).isEqualTo(325);

        minutes = "100:25";
        seconds = Task1.minutesToSeconds(minutes);

        assertThat(seconds).isEqualTo(6025);

        minutes = "00:100";
        seconds = Task1.minutesToSeconds(minutes);

        assertThat(seconds).isEqualTo(-1);

        minutes = "0000";
        seconds = Task1.minutesToSeconds(minutes);
        assertThat(seconds).isEqualTo(-1);

        minutes = "abcd";
        seconds = Task1.minutesToSeconds(minutes);
        assertThat(seconds).isEqualTo(-1);

    }
}
