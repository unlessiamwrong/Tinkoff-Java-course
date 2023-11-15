package edu.project3.LogReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class GeneralInfo {

    public static void printGeneralInfo(
        File file,
        String fileName,
        LocalDate dateTo,
        int countRequests,
        long fileSize
    ) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file, true));
        String spaces = "      ";
        printWriter.print("#### General Info" + "\n");
        printWriter.print("|" + spaces + " Metric " + spaces);
        printWriter.print("|" + spaces + " Value " + spaces + " |" + "\n");
        printWriter.print("|:" + "-".repeat(spaces.length() * 3) + ":|");
        printWriter.print(":" + "-".repeat(spaces.length() * 3) + ":|" + "\n");
        printWriter.print(spaces + " File(s)   " + spaces.repeat(2) + fileName + "\n");
        printWriter.print(spaces + " DateFrom  " + spaces.repeat(2) + dateTo + "\n");
        printWriter.print(spaces + " RequestCount    " + spaces + countRequests + "\n");
        printWriter.print(spaces + "AVGResponseSize  " + spaces + (fileSize / countRequests)  + "b\n");
        printWriter.print("\n");
        printWriter.close();
    }
}
