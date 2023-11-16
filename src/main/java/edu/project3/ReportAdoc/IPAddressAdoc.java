package edu.project3.ReportAdoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class IPAddressAdoc {

    private IPAddressAdoc() {

    }

    public static void printIPAdoc(File file, Map<String, Integer> logs) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== IP Address" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|Address" + "\n");
        out.print("|Amount" + "\n");
        out.close();
        TopThree.topThreePrint(file, logs);
    }
}

