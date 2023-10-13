package edu.hw1;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    public static Stream<Arguments> provideIntegersRotateRight() {
        return Stream.of(
            Arguments.of(8, 1, 4),
            Arguments.of(16, 1, 8),
            Arguments.of(17, 2, 12)
        );
    }

    public static Stream<Arguments> provideIntegersRotateLeft() {
        return Stream.of(
            Arguments.of(8, 1, 1),
            Arguments.of(16, 1, 1),
            Arguments.of(17, 2, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntegersRotateRight")
    @DisplayName("Cycle bit shift to the right, basic cases")
    void rotateRight_BasicCases_Test(int firstInput, int secondInput, int expected) {
        assertThat(Task7.rotateRight(firstInput, secondInput)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideIntegersRotateLeft")
    @DisplayName("Cycle bit shift to the left, basic cases")
    void rotateLeft_BasicCases_Test(int firstInput, int secondInput, int expected) {
        assertThat(Task7.rotateLeft(firstInput, secondInput)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Cycle bit shift to the right and to the left, expected Exceptions")
    void rotateRight_rotateLeft_WhenNegativeInt_ThrowsException_Test() {
        int firstInput = -17;
        int secondInput = -2;

        Assertions.assertThrows(NumberFormatException.class, () ->
            Task7.rotateRight(firstInput, secondInput)

        );

        Assertions.assertThrows(NumberFormatException.class, () ->
            Task7.rotateLeft(firstInput, secondInput)

        );
    }
}
