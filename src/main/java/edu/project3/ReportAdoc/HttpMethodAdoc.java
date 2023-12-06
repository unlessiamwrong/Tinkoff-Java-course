package edu.project3.ReportAdoc;

import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class HttpMethodAdoc {

    private final File file;
    private final Map<String, Integer> httpMethods;

    private final List<String> topThree;

    public HttpMethodAdoc(File file, CountArguments logs) {
        this.file = file;
        this.httpMethods = logs.httpMethodCount();
        this.topThree = logs.getTopThreeValues(httpMethods);
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== Http Method" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|Method" + "\n");
        out.print("|Amount" + "\n");
        out.close();
        TopThree topThreePrint = new TopThree(file, httpMethods, topThree);
        topThreePrint.run();
    }
}
