package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @ParameterizedTest
    @CsvSource({"A123BE777,true", "A123BE77,true", "123BE777,false", "A123BE7,false", "A123Be777,false",
        "A123BЫ777,false"})
    public void validatePlateNumber_Test(String input, boolean expected) {
        assertThat(Task5.validatePlateNumber(input)).isEqualTo(expected);

    }

}
