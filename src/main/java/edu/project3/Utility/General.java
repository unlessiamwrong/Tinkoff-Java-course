package edu.project3.Utility;

import edu.project3.LogRecord;
import edu.project3.ReportAdoc.PrintAdoc;
import edu.project3.ReportMd.PrintMd;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("MagicNumber")
public class General {

    public final List<String> logs; // made public for tests
    private final LogRecord logRecord;
    private final File file;
    private final long fileSize;

    public General(File file, LogRecord logRecord) {
        this.logRecord = logRecord;
        this.file = file;
        this.logs = setPeriod();
        this.fileSize = avgRequestSize();

    }

    public void run() throws IOException {
        if (".md".equals(logRecord.glob())) {
            PrintMd printMd = new PrintMd(logRecord, logs, fileSize);
            printMd.run();
        } else {
            PrintAdoc printAdoc = new PrintAdoc(logRecord, logs, fileSize);
            printAdoc.run();
        }
    }

    private List<String> setPeriod() {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                LocalDate logDate = getRequestDate(line);
                if (logDate.isAfter(logRecord.date()) || logDate.equals(logRecord.date())) {
                    result.add(line);
                }
            }

        } catch (IOException ignored) {
        }
        return result;
    }

    private LocalDate getRequestDate(String logString) {
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

    private long avgRequestSize() {
        long totalLength = 0;
        int count = 0;
        for (String str : logs) {
            totalLength += str.length();
            count++;
        }
        return totalLength / count;
    }
}
