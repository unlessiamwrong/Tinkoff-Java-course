package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

@SuppressWarnings({"MultipleStringLiterals", "MissingSwitchDefault"})
public class TodayYesterdayTomorrow extends ParserManager {

    public Optional<LocalDate> parseDate(String possibleDate) {
        if ("tomorrow".equals(possibleDate) || "yesterday".equals(possibleDate) || "today".equals(possibleDate)) {
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
