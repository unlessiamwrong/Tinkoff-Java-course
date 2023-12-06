package edu.project3.ReportAdoc;

import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class StatusCodeAdoc {

    private final File file;
    private final Map<String, Integer> statusCodes;

    private final List<String> topThree;

    public StatusCodeAdoc(File file, CountArguments logs) {
        this.file = file;
        this.statusCodes = logs.statusCodeCount();
        this.topThree = logs.getTopThreeValues(statusCodes);
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== Status Code" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|Code" + "\n");
        out.print("|Amount" + "\n");
        out.close();
        TopThree topThreePrint = new TopThree(file, statusCodes, topThree);
        topThreePrint.run();
    }
}
