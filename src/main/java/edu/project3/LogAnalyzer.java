package edu.project3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static edu.project3.LogReport.EndPoints.printEndPoint;
import static edu.project3.LogReport.GeneralInfo.printGeneralInfo;
import static edu.project3.LogReport.HttpMethod.printMethod;
import static edu.project3.LogReport.IPAddress.printIP;
import static edu.project3.LogReport.StatusCode.printStatusCode;

public class LogAnalyzer {

    public static void main(String[] args) throws IOException {
        String logFileName = args[1];
        String logFilePath = args[3];
        String logDateFrom = args[5];

        LocalDate localDate = LocalDate.parse(logDateFrom);
        Path path = Path.of(logFilePath + logFileName);
        File file = getFile(logFilePath, logFileName);
        List<String> list = setDate(file, localDate);


        finalPrint(".md", file.getName(), localDate, list.size(), Files.size(path), list);

    }

    static void finalPrint(
        String glob,
        String fileName,
        LocalDate dateTo,
        int countRequests,
        long fileSize,
        List<String> list
    ) throws IOException {
        Map<String, Integer> statusCodeCount = CollectLogInfo.statusCodeCount(list);
        Map<String, Integer> httpMethodCount = CollectLogInfo.httpMethodCount(list);
        Map<String, Integer> ipAddressCount = CollectLogInfo.ipAddressCount(list);
        Map<String, Integer> endPointCount = CollectLogInfo.endPointCount(list);

        File file = new File("logReport" + glob);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printGeneralInfo(file, fileName, dateTo, countRequests, fileSize);
        printEndPoint(file, endPointCount);
        printMethod(file, httpMethodCount);
        printStatusCode(file, statusCodeCount);
        printIP(file, ipAddressCount);
        printWriter.close();

    }

    static File getFile(String logFilePath, String logFileName) {
        Path path = Path.of(logFilePath + logFileName);
        return path.toFile();
    }

    static List<String> setDate(File file, LocalDate period) {
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
        Pattern pattern = Pattern.compile("(\\d{2}\\/\\w+\\/\\d{4}:\\d{2}:\\d{2}:\\d{2})");
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
}

