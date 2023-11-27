package edu.project3.ReportMd;

import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"MagicNumber", "MultipleStringLiterals"})
public class StatusCodeMd {

    private final File file;
    private final Map<String, Integer> statusCodes;

    private final List<String> topThree;

    public StatusCodeMd(File file, CountArguments logs) {
        this.file = file;
        this.statusCodes = logs.statusCodeCount();
        this.topThree = logs.getTopThreeValues(statusCodes);
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("#### Status Code" + "\n");
        out.print("| Code |");
        out.print(" Amount |" + "\n");
        out.print("|:" + "-".repeat(4) + ":|");
        out.print(":" + "-".repeat(6) + ":|" + "\n");
        for (String log : topThree) {
            out.print("| " + log + "  |");
            out.print(" " + statusCodes.get(log) + "  |" + "\n");
        }
        out.print("\n");
        out.close();
    }
}
