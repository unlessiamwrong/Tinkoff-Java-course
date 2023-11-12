package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NDaysAgo extends ParserManager {

    static Pattern pattern = Pattern.compile("^\\S*");

    public Optional<LocalDate> parseDate(String possibleDate) {
        if ("1 day ago".equals(possibleDate) || possibleDate.matches("\\d* days ago")) {
            Matcher matcher = pattern.matcher(possibleDate);
            while (matcher.find()) {
                int days = Integer.parseInt(possibleDate.substring(matcher.start(), matcher.end()));
                LocalDate date = LocalDate.now().minusDays(days);
                return Optional.of(date);
            }
        }
        return Optional.empty();
    }
}
