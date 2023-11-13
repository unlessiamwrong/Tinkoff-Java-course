package edu.hw6;

import edu.hw6.Task3.Executor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @TempDir
    File tempDir;

    @Test
    void abstractFilter_Test(@TempDir Path tempDir) throws IOException {
        DirectoryStream<Path> result = Executor.execute(tempDir);

        assertThat(result).isNotNull();
    }
}
