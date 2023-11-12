package edu.hw5;

import edu.hw5.Task3.ParserManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    public static Stream<Arguments> providedDates() {
        return Stream.of(
            Arguments.of("2020-10-10", Optional.of(LocalDate.of(2020, 10, 10))),
            Arguments.of("1/3/1976", Optional.of(LocalDate.of(1976, 3, 1))),
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("2020-10-10", Optional.of(LocalDate.of(2020, 10, 10))),
            Arguments.of("9 days ago", Optional.of(LocalDate.now().minusDays(9))
            )
        );
    }

    @ParameterizedTest
    @MethodSource("providedDates")
    public void parseDate(String date, Optional<LocalDate> expected) {
        assertThat(ParserManager.generalParse(date)).isEqualTo(expected);
    }
}
