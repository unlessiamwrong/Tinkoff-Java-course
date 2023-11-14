package edu.project3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzer {

    public static void main(String[] args){
        String logFileName = args[1];
        String logFilePath = args[3];
        String logPeriod = args[5];
        LocalDate localDate = LocalDate.parse(logPeriod);
        String logFormat = args[7];
        File file = getFile(logFilePath, logFileName);
        var list = setData(file, localDate);
        System.out.println(list);
    }

    static File getFile(String logFilePath, String logFileName) {
        Path path = Path.of(logFilePath + logFileName);
        File file = path.toFile();
        return file;
    }

    static List<String> setData(File file, LocalDate logPeriod) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                LocalDate logDate = parseDate(line);
                if (!logDate.isBefore(logPeriod)) {
                    result.add(line);
                }
            }

        } catch (IOException ignored) {
        }
        return result;
    }
    static LocalDate parseDate(String logString){
        Pattern pattern = Pattern.compile("\\[.*\\]");
        Matcher matcher = pattern.matcher(logString);
        if (matcher.find()) {
           String date = matcher.group();
            DateTimeFormatter dtf = new DateTimeFormatterBuilder()
                .appendPattern("dd/MMM/yyyy:HH:mm:ss")
                .toFormatter(Locale.ENGLISH);
            return LocalDate.parse(date.substring(1, date.length() - 7), dtf);
        }
        return null;
    }
}

