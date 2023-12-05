package edu.project3.ReportMd;

import edu.project3.LogRecord;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PrintMd {

    private final List<String> currentLogs;
    private final LogRecord logRecord;

    private final long fileSize;

    public PrintMd(LogRecord logRecord, List<String> logs, long fileSize) {
        this.logRecord = logRecord;
        this.currentLogs = logs;
        this.fileSize = fileSize;

    }

    public void run() throws IOException {
        File file = new File("src/main/resources/logReport.md");
        MdStatsManager mdStatsManager = new MdStatsManager(file, logRecord, currentLogs, fileSize);
        mdStatsManager.run();
    }
}
