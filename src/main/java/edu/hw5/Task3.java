package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"ReturnCount", "MultipleStringLiterals", "MissingSwitchDefault"})
public class Task3 {

    private Task3() {

    }

    public static Optional<LocalDate> parseDate(String possibleDate) {
        if (possibleDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            LocalDate date = LocalDate.parse(possibleDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return Optional.of(date);
        }

        if (possibleDate.matches("\\d{4}-\\d{2}-\\d")) {
            LocalDate date = LocalDate.parse(possibleDate, DateTimeFormatter.ofPattern("yyyy-MM-d"));
            return Optional.of(date);
        }
        if (possibleDate.matches("\\d/\\d/\\d{4}")) {
            LocalDate date = LocalDate.parse(possibleDate, DateTimeFormatter.ofPattern("d/M/yyyy"));
            return Optional.of(date);
        }
        if (possibleDate.matches("\\d/\\d/\\d{2}")) {
            LocalDate date = LocalDate.parse(possibleDate, DateTimeFormatter.ofPattern("d/M/yy"));
            return Optional.of(date);
        }

        if (("1 day ago").equals(possibleDate) || possibleDate.matches("\\d* days ago")) {
            Pattern pattern = Pattern.compile("^\\S*");
            Matcher matcher = pattern.matcher(possibleDate);
            while (matcher.find()) {
                int days = Integer.parseInt(possibleDate.substring(matcher.start(), matcher.end()));
                LocalDate date = LocalDate.now().minusDays(days);
                return Optional.of(date);
            }
        }
        if (("tomorrow").equals(possibleDate) || ("yesterday").equals(possibleDate) || ("today").equals(possibleDate)) {
            switch (possibleDate) {
                case "today" -> {
                    return Optional.of(LocalDate.now());
                }
                case "yesterday" -> {
                    return Optional.of(LocalDate.now().minusDays(1));
                }
                case "tomorrow" -> {
                    return Optional.of(LocalDate.now().plusDays(1));
                }
            }
        }

        return Optional.empty();
    }
}
