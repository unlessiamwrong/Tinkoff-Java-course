package edu.project3.ReportAdoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class StatusCodeAdoc {

    private StatusCodeAdoc() {

    }

    public static void printStatusCodeAdoc(File file, Map<String, Integer> logs) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== Status Code" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|Code" + "\n");
        out.print("|Amount" + "\n");
        out.close();
        TopThree.topThreePrint(file, logs);
    }
}
