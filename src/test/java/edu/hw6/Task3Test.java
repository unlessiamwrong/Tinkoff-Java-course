package edu.hw6;

import edu.hw6.Task3.Executor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    void abstractFilter_Test() throws IOException {
        //Arrange (current filters are in Task3.Executor)
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String expected = "C:\\Users\\Вячеслав\\Tinkoff-Java-Course\\Tinkoff-Java-Course\\test.png";

        //Act
        Executor.execute();

        //Assert
        assertThat(outputStreamCaptor
            .toString().replaceAll("\n", "").replaceAll("\r", "")).isEqualTo(expected);
    }
}
