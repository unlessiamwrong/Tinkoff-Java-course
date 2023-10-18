package edu.hw1;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    public static Stream<Arguments> provideArrays() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 5}, true),
            Arguments.of(new int[] {0, 2, 3, 4}, new int[] {0, 5}, false),
            Arguments.of(new int[] {1, 2, 3, 5}, new int[] {0, 5}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArrays")
    @DisplayName("Check if one array can be nestable to another, basic cases")
    void isNestable_BasicCases_Test(int[] firstInput, int[] secondInput, boolean expected) {
        assertThat(Task3.isNestable(firstInput, secondInput)).isEqualTo(expected);

    }

    @Test
    @DisplayName("Check if one array can be nestable to another, corner cases")
    void isNestable_CornerCases_Test() {
        int[] firstInput = new int[] {};
        int[] secondInput = new int[] {};

        assertThat(Task3.isNestable(firstInput, secondInput)).isFalse();
    }
}
