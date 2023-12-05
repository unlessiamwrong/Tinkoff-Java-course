package edu.project3.ReportAdoc;

import edu.project3.LogRecord;
import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdocStatsManager {

    private final List<String> currentLogs;
    private final LogRecord logRecord;

    private final long fileSize;

    private final File file;

    public AdocStatsManager(File file, LogRecord logRecord, List<String> logs, long fileSize) {
        this.file = file;
        this.logRecord = logRecord;
        this.currentLogs = logs;
        this.fileSize = fileSize;

    }

    public void run() throws IOException {
        CountArguments logs = new CountArguments(currentLogs);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter out = new PrintWriter(fileWriter);

        GeneralInfoAdoc generalInfoAdoc = new GeneralInfoAdoc(file, logRecord.date(), currentLogs, fileSize);
        EndPointsAdoc endPointsAdoc = new EndPointsAdoc(file, logs);
        HttpMethodAdoc httpMethodAdoc = new HttpMethodAdoc(file, logs);
        StatusCodeAdoc statusCodeAdoc = new StatusCodeAdoc(file, logs);
        IPAddressAdoc ipAddressAdoc = new IPAddressAdoc(file, logs);
        generalInfoAdoc.run();
        endPointsAdoc.run();
        httpMethodAdoc.run();
        statusCodeAdoc.run();
        ipAddressAdoc.run();
        out.close();

    }
}
