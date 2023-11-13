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
        // current filters are in Task3.Executor

        //Act
        DirectoryStream<Path> result = Executor.execute();

        //Assert
        assertThat(result).isNotNull();
    }
}
