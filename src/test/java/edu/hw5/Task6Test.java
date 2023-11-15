package edu.hw5;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    public static Stream<Arguments> providedStrings() {
        return Stream.of(
            Arguments.of("abc", "achfdbaabgabcaabg", true),
            Arguments.of("abc", "abc", true),
            Arguments.of("abc", "acccccbbc", true),
            Arguments.of("abc", "bcc", false),
            Arguments.of("abc", "", false)
        );
    }

    @ParameterizedTest
    @MethodSource("providedStrings")
    public void isSubsequence_Test(String inputOne, String inputTwo, boolean expected) {
        assertThat(Task6.isSubsequence(inputOne, inputTwo)).isEqualTo(expected);
    }
}
