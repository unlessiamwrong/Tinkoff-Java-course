package edu.project3.ReportAdoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import static edu.project3.Utility.General.getTopThreeValues;

@SuppressWarnings("MultipleStringLiterals")
public class TopThree {

    private TopThree() {

    }

    public static void topThreePrint(File file, Map<String, Integer> logs) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        var topThree = getTopThreeValues(logs);
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
