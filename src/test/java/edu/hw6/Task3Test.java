package edu.hw6;

import edu.hw6.Task3.Executor;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {


    @Test
    void abstractFilter_Test(@TempDir Path tempDir){
        DirectoryStream<Path> result = Executor.execute(tempDir);

        assertThat(result).isNotNull();
    }
}
