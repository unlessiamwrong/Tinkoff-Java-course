package edu.project3.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static edu.project3.ReportAdoc.PrintAdoc.printAdoc;
import static edu.project3.ReportMd.PrintMd.printMd;

@SuppressWarnings("MagicNumber")
public class General {

    private General() {

    }

    public static void finalPrint(String glob, LocalDate dateTo, int countArguments, long fileSize, List<String> list)
        throws IOException {
        if (".md".equals(glob)) {
            printMd(dateTo, countArguments, fileSize, list);
        } else {
            printAdoc(dateTo, countArguments, fileSize, list);
        }
    }

    public static List<String> setDateTo(File file, LocalDate period) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                LocalDate logDate = getRequestDate(line);
                if (logDate.isAfter(period) || logDate.equals(period)) {
                    result.add(line);
                }
            }

        } catch (IOException ignored) {
        }
        return result;
    }

    static LocalDate getRequestDate(String logString) {
        Pattern pattern = Pattern.compile("(\\d{2}/\\w+/\\d{4}:\\d{2}:\\d{2}:\\d{2})");
        Matcher matcher = pattern.matcher(logString);
        if (matcher.find()) {
            String date = matcher.group();
            DateTimeFormatter dtf = new DateTimeFormatterBuilder()
                .appendPattern("dd/MMM/yyyy:HH:mm:ss")
                .toFormatter(Locale.ENGLISH);
            return LocalDate.parse(date, dtf);
        }
        return null;
    }

    public static List<String> getTopThreeValues(Map<String, Integer> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue()
                .reversed())
            .limit(3)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public static long avgResponseSize(List<String> list) {
        long totalLength = 0;
        int count = 0;
        for (String str : list) {
            totalLength += str.length();
            count++;
        }
        return totalLength / count;
    }
}
