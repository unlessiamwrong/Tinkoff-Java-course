package edu.hw6;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task1.readKey;
import static edu.hw6.Task1.writeKey;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void writeKey_Test() {
        //Arrange
        String fileName = "DiskMap.txt";
        String key = "Slava";
        String value = "44";

        //Act
        writeKey(fileName, key, value);
        boolean result = Files.exists(Path.of("DiskMap.txt"));

        //Assert
        assertThat(result).isTrue();

    }

    @Test
    void readKey_Test() {
        //Arrange
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String fileName = "DiskMap.txt";

        //Act
        readKey(fileName);

        //Assert
        assertThat(outputStreamCaptor.toString().indexOf("S")).isEqualTo(0);
        assertThat(outputStreamCaptor.toString().indexOf("v")).isEqualTo(3);

    }
}
