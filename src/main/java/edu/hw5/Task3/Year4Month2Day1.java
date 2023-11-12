package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Year4Month2Day1 extends ParserManager {

    public Optional<LocalDate> parseDate(String possibleDate) {
        if (possibleDate.matches("\\d{4}-\\d{2}-\\d")) {
            LocalDate date = LocalDate.parse(possibleDate, DateTimeFormatter.ofPattern("yyyy-MM-d"));
            return Optional.of(date);
        }
        return Optional.empty();
    }
}
