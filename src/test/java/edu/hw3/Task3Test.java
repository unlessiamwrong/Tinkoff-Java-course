package edu.hw3;

import java.util.HashMap;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task3Test {

    public static Stream<Arguments> provideArrays() {
        return Stream.of(
            Arguments.of(new String[] {"a", "bb", "a", "bb"}, new HashMap<String, Integer>() {{
                put("bb", 2);
                put("a", 2);
            }}),
            Arguments.of(new String[] {"this", "and", "that", "and"}, new HashMap<String, Integer>() {{
                put("that", 1);
                put("and", 2);
                put("this", 1);
            }}),
            Arguments.of(new String[] {"код", "код", "код", "bug"}, new HashMap<String, Integer>() {{
                put("код", 3);
                put("bug", 1);
            }}),
            Arguments.of(new String[] {"1", "1", "2", "2"}, new HashMap<String, Integer>() {{
                put("1", 2);
                put("2", 2);
            }})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArrays")
    void freqDict_BaseCases_Test(String[] input, HashMap<String, Integer> expected) {
        assertThat(Task3.freqDict(input)).isEqualTo(expected);

    }

    @Test
    void freqDict_InputNull_ReturnNull_Test() {
        //Assert
        String[] tempObject = new String[] {};
        HashMap<String, Integer> expected = new HashMap<>();

        //Act
        HashMap<String, Integer> result = Task3.freqDict(tempObject);

        //Assert
        assertThat(result).isEqualTo(expected);

    }
}
