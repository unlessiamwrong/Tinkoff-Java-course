package edu.project3.ReportMd;

import edu.project3.Utility.CountArguments;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MagicNumber")
public class HttpMethodMd {

    private final File file;
    private final Map<String, Integer> httpMethods;

    private final List<String> topThree;

    public HttpMethodMd(File file, CountArguments logs) {
        this.file = file;
        this.httpMethods = logs.httpMethodCount();
        this.topThree = logs.getTopThreeValues(httpMethods);
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("#### HTTP Method" + "\n");
        out.print("| Method |");
        out.print(" Amount |" + "\n");
        out.print("|:" + "-".repeat(6) + ":|");
        out.print(":" + "-".repeat(6) + ":|" + "\n");
        for (String log : topThree) {
            out.print("|  " + log + "   |");
            out.print(" " + httpMethods.get(log) + "  |" + "\n");
        }
        out.print("\n");
        out.close();
    }
}
