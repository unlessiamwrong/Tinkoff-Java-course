package edu.project3.ReportAdoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("MultipleStringLiterals")
public class GeneralInfoAdoc {

    private final File file;
    private final List<String> logs;
    private final LocalDate date;
    private final long fileSize;

    public GeneralInfoAdoc(File file, LocalDate date, List<String> logs, long fileSize) {
        this.file = file;
        this.logs = logs;
        this.date = date;
        this.fileSize = fileSize;
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== General Info" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|Metric" + "\n");
        out.print("|Value" + "\n");
        out.print("|File(s) pass:[<br>] DateFrom pass:[<br>] RequestCount pass:[<br>] AVGResponseSize" + "\n");
        out.print("|" + file.getName() + " pass:[<br>]");
        out.print(date + " pass:[<br>]");
        out.print(logs.size() + " pass:[<br>]");
        out.print(fileSize + "b");
        out.print("""

            |====
            """);
        out.close();
    }
}
