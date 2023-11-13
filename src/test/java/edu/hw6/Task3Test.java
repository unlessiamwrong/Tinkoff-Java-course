package edu.hw6;

import edu.hw6.Task3.Executor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    void abstractFilter_Test() throws IOException {
        //Arrange
        Path path = Path.of("C:\\Users\\Вячеслав\\Tinkoff-Java-Course\\Tinkoff-Java-Course");

        //Act
        DirectoryStream<Path> result = Executor.execute(path);

        //Assert
        assertThat(result).isNotNull();
    }
}
