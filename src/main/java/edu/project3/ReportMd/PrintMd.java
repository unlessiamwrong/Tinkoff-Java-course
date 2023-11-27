package edu.project3.ReportMd;

import edu.project3.LogRecord;
import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        CountArguments logs = new CountArguments(currentLogs);

        File file = new File("src/main/resources/logReport.md");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter out = new PrintWriter(fileWriter);

        GeneralInfoMd generalInfoMd = new GeneralInfoMd(file, logRecord.date(), currentLogs, fileSize);
        EndPointsMd endPointsMd = new EndPointsMd(file, logs);
        HttpMethodMd httpMethodMd = new HttpMethodMd(file, logs);
        StatusCodeMd statusCodeMd = new StatusCodeMd(file, logs);
        IPAddressMd ipAddressMd = new IPAddressMd(file, logs);
        generalInfoMd.run();
        endPointsMd.run();
        httpMethodMd.run();
        statusCodeMd.run();
        ipAddressMd.run();

        out.close();
    }
}
