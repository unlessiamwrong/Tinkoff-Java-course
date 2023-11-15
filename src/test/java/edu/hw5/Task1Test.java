package edu.hw5;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    public static Stream<Arguments> providedArrays() {
        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(
                "2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
            )), Duration.of(220, ChronoUnit.MINUTES)),
            Arguments.of(new ArrayList<>(Arrays.asList(
                "2023-01-22, 10:32 - 2023-01-22, 15:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
            )), Duration.of(274, ChronoUnit.MINUTES)),
            Arguments.of(new ArrayList<>(Arrays.asList(
                "2023-06-06, 18:00 - 2023-06-06, 22:00",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
            )), Duration.of(235, ChronoUnit.MINUTES))
        );
    }

    @ParameterizedTest
    @MethodSource("providedArrays")
    public void averageTimeSession_Test(List<String> input, Duration expected) {
        assertThat(Task1.averageTimeSession(input)).isEqualTo(expected);

    }
}
