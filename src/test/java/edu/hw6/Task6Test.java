package edu.hw6;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task6.PortScanner.scanPorts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    void portScanner_Test() throws IOException {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        scanPorts();

        assertThat(outputStreamCaptor.size()).isEqualTo(3221707);
    }
}
