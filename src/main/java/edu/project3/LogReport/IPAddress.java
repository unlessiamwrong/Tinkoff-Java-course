package edu.project3.LogReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import static edu.project3.CollectLogInfo.getTop3Values;

public class IPAddress {
    public static void printIP(File file, Map<String, Integer> logs) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file, true));
        String spaces = "      ";
        printWriter.print("#### IP-address" + "\n");
        printWriter.print("|" + spaces + "Address " + spaces);
        printWriter.print("|" + spaces + " Amount" + spaces + " |" + "\n");
        printWriter.print("|:" + "-".repeat(spaces.length() * 3) + ":|");
        printWriter.print(":" + "-".repeat(spaces.length() * 3) + ":|" + "\n");
        var topThree = getTop3Values(logs);
        for (var i : topThree) {
            printWriter.print("    " + i + spaces);
            printWriter.print(spaces + logs.get(i) + "\n");
        }
        printWriter.print("\n");
        printWriter.close();
    }
}
