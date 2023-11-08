package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.TemporalAdjusters.next;

@SuppressWarnings({"MagicNumber", "ParameterAssignment"})
public class Task2 {

    private Task2() {

    }

    public static List<LocalDate> getEveryFriday13(LocalDate year) {
        LocalDate yearEnd = year.plusYears(1);
        List<LocalDate> days = new ArrayList<>();

        while (year.isBefore(yearEnd)) {
            if (year.getDayOfMonth() == 13 && year.getDayOfWeek() == DayOfWeek.FRIDAY) {
                days.add(year);
            }
            year = year.plusDays(1);
        }
        return days;
    }

    public static LocalDate getEveryFriday13TempAdj(LocalDate year) {
        LocalDate yearEnd = year.plusYears(1);

        while (year.isBefore(yearEnd)) {
            LocalDate currentDate = year.with(next(DayOfWeek.FRIDAY));
            if (currentDate.getDayOfMonth() == 13) {
                return currentDate;
            }
            year = year.plusWeeks(1);
        }
        return null;
    }

}

