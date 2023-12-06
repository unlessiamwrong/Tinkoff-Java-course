package edu.project3.ReportAdoc;

import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class EndPointsAdoc {

    private final File file;
    private final Map<String, Integer> endPoints;

    private final List<String> topThree;

    public EndPointsAdoc(File file, CountArguments logs) {
        this.file = file;
        this.endPoints = logs.endPointCount();
        this.topThree = logs.getTopThreeValues(endPoints);
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== EndPoint" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|EndPoint" + "\n");
        out.print("|Amount" + "\n");
        out.close();
        TopThree topThreePrint = new TopThree(file, endPoints, topThree);
        topThreePrint.run();
    }
}
