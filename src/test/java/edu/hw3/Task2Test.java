package edu.hw3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    public static Stream<Arguments> provideArrays() {
        return Stream.of(
            Arguments.of(("()()()"), Arrays.asList("()", "()", "()")),
            Arguments.of(("((()))"), List.of("((()))")),
            Arguments.of(("((()))(())()()(()())"), Arrays.asList("((()))", "(())", "()", "()", "(()())"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideArrays")
    void clusterize_BasicCases_Test(String input, List<String> expected) {
        var result = Task2.clusterize(input);

        assertThat(result).isEqualTo(expected);

    }

    @Test
    void clusterize_InputUnbalanceSequence_ThrowException_Test() {
        String tempStr = ")()";

        Assertions.assertThrows(RuntimeException.class, () ->
            Task2.clusterize(tempStr)
        );

    }
}
