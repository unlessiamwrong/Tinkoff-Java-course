package edu.project3.ReportMd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import static edu.project3.ReportMd.EndPointsMd.printEndPointMd;
import static edu.project3.ReportMd.GeneralInfoMd.printGeneralInfoMd;
import static edu.project3.ReportMd.HttpMethodMd.printMethodMd;
import static edu.project3.ReportMd.IPAddressMd.printIPMd;
import static edu.project3.ReportMd.StatusCodeMd.printStatusCodeMd;
import static edu.project3.Utility.CountArguments.endPointCount;
import static edu.project3.Utility.CountArguments.httpMethodCount;
import static edu.project3.Utility.CountArguments.ipAddressCount;
import static edu.project3.Utility.CountArguments.statusCodeCount;

public class PrintMd {

    private PrintMd() {

    }

    public static void printMd(
        LocalDate dateTo,
        int countArguments,
        long fileSize,
        List<String> list
    ) throws IOException {
        Map<String, Integer> statusCodes = statusCodeCount(list);
        Map<String, Integer> httpMethods = httpMethodCount(list);
        Map<String, Integer> ipAddresses = ipAddressCount(list);
        Map<String, Integer> endPoints = endPointCount(list);

        File file = new File("src/main/resources/logReport.md");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter out = new PrintWriter(fileWriter);
        printGeneralInfoMd(file, dateTo, countArguments, fileSize);
        printEndPointMd(file, endPoints);
        printMethodMd(file, httpMethods);
        printStatusCodeMd(file, statusCodes);
        printIPMd(file, ipAddresses);
        out.close();
    }
}
