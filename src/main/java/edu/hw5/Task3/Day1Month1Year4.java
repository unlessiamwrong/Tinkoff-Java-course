package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Day1Month1Year4 extends ParserManager {

    public Optional<LocalDate> parseDate(String possibleDate) {
        if (possibleDate.matches("\\d/\\d/\\d{4}")) {
            LocalDate date = LocalDate.parse(possibleDate, DateTimeFormatter.ofPattern("d/M/yyyy"));
            return Optional.of(date);
        }
        return Optional.empty();
    }
}
