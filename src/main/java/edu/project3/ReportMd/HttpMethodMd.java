package edu.project3.ReportMd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import static edu.project3.Utility.General.getTopThreeValues;

@SuppressWarnings("MagicNumber")
public class HttpMethodMd {

    private HttpMethodMd() {

    }

    public static void printMethodMd(File file, Map<String, Integer> logs) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("#### HTTP Method" + "\n");
        out.print("| Method |");
        out.print(" Amount |" + "\n");
        out.print("|:" + "-".repeat(6) + ":|");
        out.print(":" + "-".repeat(6) + ":|" + "\n");
        var topThree = getTopThreeValues(logs);
        for (var i : topThree) {
            out.print("|  " + i + "   |");
            out.print(" " + logs.get(i) + "  |" + "\n");
        }
        out.print("\n");
        out.close();
    }
}
