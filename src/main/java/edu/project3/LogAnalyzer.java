package edu.project3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static edu.project3.Utility.General.avgRequestSize;
import static edu.project3.Utility.General.finalPrint;
import static edu.project3.Utility.General.setDateTo;

@SuppressWarnings("MagicNumber")
public class LogAnalyzer {

    private LogAnalyzer() {

    }

    public static void analyze(String[] args) throws IOException {
        String filePath = args[4];
        String dateFrom = "";
        String dateTo = "";
        String fileGlob = "";

        for (int i = 0; i < args.length; i++) {
            String current = args[i];
            if ("--from".equals(current)) {
                dateFrom = args[i + 1];
            } else if ("--to".equals(current)) {
                dateTo = args[i + 1];
            } else if ("--format".equals(current)) {
                if ("markdown".equals(args[i + 1])) {
                    fileGlob = ".md";
                } else {
                    fileGlob = ".adoc";
                }
            }
        }

        LocalDate localDate = LocalDate.parse(dateFrom);
        Path path = Path.of(filePath);
        File file = path.toFile();
        List<String> list = setDateTo(file, localDate);

        finalPrint(fileGlob, localDate, list.size(), avgRequestSize(list), list);

    }
}

