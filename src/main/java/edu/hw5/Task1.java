package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SuppressWarnings("MultipleStringLiterals")
public class Task1 {

    private Task1() {

    }

    public static Duration averageTimeSession(List<String> session) {
        return session.stream()
            .map(str -> str.split("\\D{3}"))
            .map(dates -> {
                var dateOne = LocalDateTime.parse(dates[0], DateTimeFormatter.ofPattern("yyyy-MM-dd', 'HH:mm"));
                var dateTwo = LocalDateTime.parse(dates[1], DateTimeFormatter.ofPattern("yyyy-MM-dd', 'HH:mm"));
                return new LocalDateTime[] {dateOne, dateTwo};
            })
            .map(dates -> (Duration.between(dates[0], dates[1])))
            .mapToLong(Duration::toMillis)
            .average()
            .stream()
            .mapToObj(time -> Duration.ofMillis((long) time)).findFirst().get();
    }
}
