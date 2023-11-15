package edu.hw5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    public void getEveryFriday13_Test() {
        //Arrange
        LocalDate year = LocalDate.of(1925, 1, 1);
        List<LocalDate> expected = new ArrayList<>(Arrays.asList(
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13)
        ));

        //Act
        List<LocalDate> result = Task2.getEveryFriday13(year);

        //Assert
        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void getEveryFriday13TempAdj_Test() {
        //Arrange
        LocalDate year = LocalDate.of(1925, 1, 1);
        LocalDate expected = LocalDate.of(1925, 2, 13);

        //Act
        LocalDate result = Task2.getEveryFriday13TempAdj(year);

        //Assert
        assertThat(result).isEqualTo(expected);

    }
}
