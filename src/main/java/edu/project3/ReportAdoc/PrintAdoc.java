package edu.project3.ReportAdoc;

import edu.project3.LogRecord;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PrintAdoc {

    private final List<String> currentLogs;
    private final LogRecord logRecord;

    private final long fileSize;

    public PrintAdoc(LogRecord logRecord, List<String> logs, long fileSize) {
        this.logRecord = logRecord;
        this.currentLogs = logs;
        this.fileSize = fileSize;

    }

    public void run() throws IOException {

        File file = new File("src/main/resources/logReport.adoc");
        AdocStatsManager adocStatsManager = new AdocStatsManager(file, logRecord, currentLogs, fileSize);
        adocStatsManager.run();

    }
}
