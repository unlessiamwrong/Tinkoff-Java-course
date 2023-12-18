package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task2.cloneFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void cloneFile_Test() throws IOException {
        //Arrange
        Path path = Path.of("DiskMap.txt");
        Path expectedPathOne = Path.of("DiskMap - copy.txt");

        //Act
        cloneFile(path);
        cloneFile(path);
        boolean resultOne = Files.exists(expectedPathOne);

        //Assert
        assertThat(resultOne).isTrue();

    }
}
