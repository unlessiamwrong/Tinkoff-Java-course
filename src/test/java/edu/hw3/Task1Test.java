package edu.hw3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @ParameterizedTest
    @CsvSource({"Hello world!, Svool dliow!", "ABc, ZYx", "AaA, ZzZ"})
    void atbash_String_Test(String input, String excepted) {
        String result = Task1.atbash(input);

        assertThat(result).isEqualTo(excepted);

    }

    @Test
    void atbash_InputNull_ReturnNull_Test() {
        //Assert
        String tempObject = null;

        //Act
        String result = Task1.atbash(tempObject);

        //Assert
        assertThat(result).isEqualTo(null);

    }
}
