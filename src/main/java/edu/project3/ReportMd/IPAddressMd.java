package edu.project3.ReportMd;

import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"MagicNumber", "MultipleStringLiterals"}) public class IPAddressMd {
    private final File file;
    private final Map<String, Integer> ipAddresses;

    private final List<String> topThree;

    public IPAddressMd(File file, CountArguments logs) {
        this.file = file;
        this.ipAddresses = logs.ipAddressCount();
        this.topThree = logs.getTopThreeValues(ipAddresses);
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("#### IP-address" + "\n");
        out.print("|     Address     |");
        out.print(" Amount |" + "\n");
        out.print("|:" + "-".repeat(15) + ":|");
        out.print(":" + "-".repeat(6) + ":|" + "\n");
        for (String log : topThree) {
            out.print("| " + log + "  |");
            out.print("  " + ipAddresses.get(log) + "  |" + "\n");
        }
        out.print("\n");
        out.close();
    }
}

