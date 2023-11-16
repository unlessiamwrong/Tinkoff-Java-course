package edu.project3.ReportAdoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HttpMethodAdoc {

    private HttpMethodAdoc() {

    }

    public static void printMethodAdoc(File file, Map<String, Integer> logs) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== Http Method" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|Method" + "\n");
        out.print("|Amount" + "\n");
        out.close();
        TopThree.topThreePrint(file, logs);
    }
}
