package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task4.composition;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    void composition_Test() throws IOException {
        //Arrange
        Path path = Path.of("Quote.txt");

        //Act
        composition();
        boolean result = Files.exists(path);

        //Assert
        assertThat(result).isTrue();
    }
}
