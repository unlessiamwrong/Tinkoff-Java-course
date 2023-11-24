package edu.hw6;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task1.readKey;
import static edu.hw6.Task1.writeKey;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void writeKey_Test() {
        //Arrange
        String fileName = "src/main/resources/DiskMap.txt";
        String key = "Slava";
        String value = "44";

        //Act
        writeKey(fileName, key, value);
        boolean result = Files.exists(Path.of("src/main/resources/DiskMap.txt"));

        //Assert
        assertThat(result).isTrue();

    }

    @Test
    void readKey_Test() {
        //Arrange
        String fileName = "src/main/resources/DiskMap.txt";

        //Act
        List<String> result = readKey(fileName);
        System.out.println(result);

        //Assert
        assertThat(result.getFirst()).isEqualTo("Slava:44");

    }
}
