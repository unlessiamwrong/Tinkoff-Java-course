package edu.project3.ReportAdoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@SuppressWarnings("MultipleStringLiterals")
public class GeneralInfoAdoc {

    private GeneralInfoAdoc() {

    }

    public static void printGeneralInfoAdoc(
        File file,
        LocalDate dateFrom,
        int countRequests,
        long fileSize
    ) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("==== General Info" + "\n");
        out.print("[cols=2]" + "\n");
        out.print("|====" + "\n");
        out.print("|Metric" + "\n");
        out.print("|Value" + "\n");
        out.print("|File(s) pass:[<br>] DateFrom pass:[<br>] RequestCount pass:[<br>] AVGResponseSize" + "\n");
        out.print("|" + file.getName() + " pass:[<br>]");
        out.print(dateFrom + " pass:[<br>]");
        out.print(countRequests + " pass:[<br>]");
        out.print(fileSize + "b");
        out.print("""

            |====
            """);
        out.close();
    }
}
