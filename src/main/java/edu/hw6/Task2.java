package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("MultipleStringLiterals")
public class Task2 {

    private Task2() {

    }

    public static void cloneFile(Path path) throws IOException {
        File file = path.toFile();
        if (file.isFile()) {
            String[] fileNameFormat = file.getName().split("\\W");
            String fileName = fileNameFormat[0];
            String fileFormat = "." + fileNameFormat[1];
            Path copyFilePath = Paths.get(fileName + " - copy" + fileFormat);
            if (copyFilePath.toFile().isFile()) {
                int countCopy = 1;
                while (Paths.get(fileName + " - copy" + " (" + countCopy + ")" + fileFormat).toFile()
                    .isFile()) {
                    countCopy += 1;
                }
                Files.createFile(Paths.get(fileName + " - copy" + " (" + countCopy + ")" + fileFormat));
            } else {
                Files.createFile(copyFilePath);
            }
        } else {
            Files.createFile(path);
        }
    }
}
