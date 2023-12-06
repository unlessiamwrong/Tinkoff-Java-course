package edu.project3.ReportAdoc;

import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class IPAddressAdoc {

    private final File file;
    private final Map<String, Integer> ipAddresses;

    private final List<String> topThree;

    public IPAddressAdoc(File file, CountArguments logs) {
        this.file = file;
        this.ipAddresses = logs.ipAddressCount();
        this.topThree = logs.getTopThreeValues(ipAddresses);
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== IP Address" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|Address" + "\n");
        out.print("|Amount" + "\n");
        out.close();
        TopThree topThreePrint = new TopThree(file, ipAddresses, topThree);
        topThreePrint.run();
    }
}

