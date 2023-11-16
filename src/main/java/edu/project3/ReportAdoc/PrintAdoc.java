package edu.project3.ReportAdoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import static edu.project3.ReportAdoc.EndPointsAdoc.printEndPointAdoc;
import static edu.project3.ReportAdoc.GeneralInfoAdoc.printGeneralInfoAdoc;
import static edu.project3.ReportAdoc.HttpMethodAdoc.printMethodAdoc;
import static edu.project3.ReportAdoc.IPAddressAdoc.printIPAdoc;
import static edu.project3.ReportAdoc.StatusCodeAdoc.printStatusCodeAdoc;
import static edu.project3.Utility.CountArguments.endPointCount;
import static edu.project3.Utility.CountArguments.httpMethodCount;
import static edu.project3.Utility.CountArguments.ipAddressCount;
import static edu.project3.Utility.CountArguments.statusCodeCount;

public class PrintAdoc {

    private PrintAdoc() {

    }

    public static void printAdoc(
        LocalDate dateTo,
        int countArguments,
        long fileSize,
        List<String> list
    ) throws IOException {
        Map<String, Integer> statusCodes = statusCodeCount(list);
        Map<String, Integer> httpMethods = httpMethodCount(list);
        Map<String, Integer> ipAddresses = ipAddressCount(list);
        Map<String, Integer> endPoints = endPointCount(list);

        File file = new File("src/main/resources/logReport.adoc");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter out = new PrintWriter(fileWriter);
        printGeneralInfoAdoc(file, dateTo, countArguments, fileSize);
        printEndPointAdoc(file, endPoints);
        printMethodAdoc(file, httpMethods);
        printStatusCodeAdoc(file, statusCodes);
        printIPAdoc(file, ipAddresses);
        out.close();

    }
}
