package edu.project3;

import edu.project3.Utility.General;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

@SuppressWarnings("MagicNumber")
public class LogAnalyzer {

    private LogAnalyzer() {

    }

    public static void analyze(String[] args) throws IOException {
        Path filePath = Path.of(args[4]);
        String dateFrom = "";
        String dateTo = "";
        String fileGlob = "";

        for (int i = 0; i < args.length; i++) {
            String current = args[i];
            if ("--from".equals(current)) {
                dateFrom = args[i + 1];
            } else if ("--to".equals(current)) {
                dateTo = args[i + 1];
            } else if ("--format".equals(current)) {
                if ("markdown".equals(args[i + 1])) {
                    fileGlob = ".md";
                } else {
                    fileGlob = ".adoc";
                }
            }
        }

        LocalDate date = LocalDate.parse(dateFrom);
        LogRecord logRecord = new LogRecord(fileGlob, filePath, date);
        File file = logRecord.path().toFile();

        General print = new General(logRecord, file);
        print.run();

    }
}

