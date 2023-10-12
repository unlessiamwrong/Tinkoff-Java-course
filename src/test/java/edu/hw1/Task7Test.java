package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Cycle bit shift")
    void simpleShiftTest() throws Exception {
        int number;
        int shift;
        int shiftedNumber;

        number = 8;
        shift = 1;
        shiftedNumber = Task7.rotateRight(number, shift);

        assertThat(shiftedNumber).isEqualTo(4);

        number = 16;

        shiftedNumber = Task7.rotateLeft(number, shift);

        assertThat(shiftedNumber).isEqualTo(1);

        number = 17;
        shift = 2;
        shiftedNumber = Task7.rotateLeft(number, shift);
        assertThat(shiftedNumber).isEqualTo(6);

        number = -17;
        shift = -2;
        try {
            Task7.rotateLeft(number, shift);
        } catch (Exception e) {
            //known exception
        }

        number = -16;
        shift = -1;
        try {
            Task7.rotateRight(number, shift);
        } catch (Exception e) {
            //known exception
        }
    }
}
