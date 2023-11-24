package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task6.PortScanner.scanPorts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    void portScanner_Test() throws IOException {
        File file = Path.of("closedPorts.txt").toFile();
        scanPorts();

        assertThat(file.length()).isGreaterThan(15);
    }
}
