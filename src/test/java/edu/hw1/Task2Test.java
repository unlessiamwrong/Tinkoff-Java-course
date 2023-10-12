package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Count digits amount from number")
    void simpleCountTest() {
        int digitsAmount;
        int number;

        number = 5000;
        digitsAmount = Task2.countDigits(number);

        assertThat(digitsAmount).isEqualTo(4);

        number = 500;
        digitsAmount = Task2.countDigits(number);

        assertThat(digitsAmount).isEqualTo(3);

        number = 50;
        digitsAmount = Task2.countDigits(number);

        assertThat(digitsAmount).isEqualTo(2);

        number = 5;
        digitsAmount = Task2.countDigits(number);

        assertThat(digitsAmount).isEqualTo(1);

        number = 0;
        digitsAmount = Task2.countDigits(number);

        assertThat(digitsAmount).isEqualTo(1);

        number = -5;
        digitsAmount = Task2.countDigits(number);

        assertThat(digitsAmount).isEqualTo(-1);
    }
}
