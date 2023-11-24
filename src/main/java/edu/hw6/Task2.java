package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings({"MultipleStringLiterals", "ReturnCount"})
public class Task2 {

    private Task2() {

    }

    public static void cloneFile(Path path) throws IOException {
        File file = path.toFile();
        if (!file.isFile()) {
            Files.createFile(path);
            return;
        }
        int countCopy = 0;
        String[] fileNameFormat = file.getName().split("\\W");
        String fileName = fileNameFormat[0];
        String fileFormat = "." + fileNameFormat[1];
        Path copyFilePath = constructPath(fileName, fileFormat, countCopy);
        countCopy++;
        if (!copyFilePath.toFile().isFile()) {
            Files.createFile(copyFilePath);
            return;
        }
        while (constructPath(fileName, fileFormat, countCopy).toFile()
            .isFile()) {
            countCopy += 1;
        }
        Files.createFile(constructPath(fileName, fileFormat, countCopy));
    }

    private static Path constructPath(String fileName, String fileFormat, int countCopy) {
        if (countCopy == 0) {
            return Paths.get(fileName + " - copy" + fileFormat);
        }
        return Paths.get(fileName + " - copy" + " (" + countCopy + ")" + fileFormat);
    }
}
