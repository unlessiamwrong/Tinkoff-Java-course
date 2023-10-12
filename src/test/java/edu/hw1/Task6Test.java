package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Count amount of steps to make Kaprekar's number")
    void simpleCountTest() throws Exception {
        int number;
        int counter;

        number = 6621;
        counter = Task6.countK(number);

        assertThat(counter).isEqualTo(5);

        number = 6554;
        counter = Task6.countK(number);

        assertThat(counter).isEqualTo(4);

        number = 1001;
        counter = Task6.countK(number);

        assertThat(counter).isEqualTo(4);

        number = 1000;
        try {
            Task6.countK(number);
        } catch (Exception e) {
            //known exception
        }
    }
}
