package edu.project3.ReportMd;

import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MagicNumber") public class EndPointsMd {

    private final File file;
    private final Map<String, Integer> endPoints;

    private final List<String> topThree;

    public EndPointsMd(File file, CountArguments logs) {
        this.file = file;
        this.endPoints = logs.endPointCount();
        this.topThree = logs.getTopThreeValues(endPoints);
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("#### EndPoint" + "\n");
        out.print("|       EndPoint       |");
        out.print(" Amount  |" + "\n");
        out.print("|:" + "-".repeat(20) + ":|");
        out.print(":" + "-".repeat(7) + ":|" + "\n");
        for (String log : topThree) {
            out.print("| " + log + " |");
            out.print("  " + endPoints.get(log) + "  |" + "\n");
        }
        out.print("\n");
        out.close();
    }
}
