package edu.project3.ReportMd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings({"MagicNumber", "MultipleStringLiterals"})
public class GeneralInfoMd {

    private final File file;
    private final List<String> logs;
    private final LocalDate date;
    private final long fileSize;

    public GeneralInfoMd(File file, LocalDate date, List<String> logs, long fileSize) {
        this.file = file;
        this.logs = logs;
        this.date = date;
        this.fileSize = fileSize;
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("#### General Info" + "\n");
        out.print("|     Metric      |");
        out.print("   Value    |" + "\n");
        out.print("|:" + "-".repeat(15) + ":|");
        out.print(":" + "-".repeat(10) + ":|" + "\n");
        out.print("|     File(s)     |  " + file.getName() + "  |" + "\n");
        out.print("|    DateFrom     | " + date + " |" + "\n");
        out.print("|  RequestCount   |   " + logs.size() + "    |" + "\n");
        out.print("| AVGResponseSize |    " + fileSize + "b" + "    |" + "\n");
        out.print("\n");
        out.close();
    }
}
