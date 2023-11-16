package edu.project3.ReportMd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@SuppressWarnings({"MagicNumber", "MultipleStringLiterals"})
public class GeneralInfoMd {

    private GeneralInfoMd() {

    }

    public static void printGeneralInfoMd(
        File file,
        LocalDate dateTo,
        int countRequests,
        long fileSize
    ) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.print("#### General Info" + "\n");
        out.print("|     Metric      |");
        out.print("   Value    |" + "\n");
        out.print("|:" + "-".repeat(15) + ":|");
        out.print(":" + "-".repeat(10) + ":|" + "\n");
        out.print("|     File(s)     |  " + file.getName() + "  |" + "\n");
        out.print("|    DateFrom     | " + dateTo + " |" + "\n");
        out.print("|  RequestCount   |   " + countRequests + "    |" + "\n");
        out.print("| AVGResponseSize |    " + fileSize + "b" + "    |" + "\n");
        out.print("\n");
        out.close();
    }
}
