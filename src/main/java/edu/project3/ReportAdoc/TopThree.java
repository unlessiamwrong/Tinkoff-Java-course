package edu.project3.ReportAdoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MultipleStringLiterals") public class TopThree {

    private final File file;
    private final Map<String, Integer> logs;
    private final List<String> topThree;

    TopThree(File file, Map<String, Integer> logs, List<String> topThree) {
        this.file = file;
        this.logs = logs;
        this.topThree = topThree;

    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("|" + topThree.get(0) + "pass:[<br>]");
        for (int i = 1; i < topThree.size(); i++) {
            out.print(topThree.get(i) + "pass:[<br>]");
        }
        out.print("\n");
        out.print("|" + logs.get(topThree.get(0)) + "pass:[<br>]");
        for (int i = 1; i < topThree.size(); i++) {
            out.print(logs.get(topThree.get(i)) + "pass:[<br>]");
        }
        out.print("""

            |====
            """);
        out.close();
    }
}
