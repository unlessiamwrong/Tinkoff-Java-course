package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Optional;

public abstract class ParserManager {

    public ParserManager() {
    }

    public static Optional<LocalDate> generalParse(String possibleDate) {
        LinkedList<ParserManager> linkedList = new LinkedList<>();
        linkedList.add(new Day1Month1Year4());
        linkedList.add(new Day1Month1Year2());
        linkedList.add(new Year4Month2Day1());
        linkedList.add(new Year4Month2Day2());
        linkedList.add(new NDaysAgo());
        linkedList.add(new TodayYesterdayTomorrow());
        for (var object : linkedList) {
            Optional<LocalDate> result = object.parseDate(possibleDate);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }

    public abstract Optional<LocalDate> parseDate(String possibleDate);

}
