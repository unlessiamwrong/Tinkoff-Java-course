package edu.hw10;

import edu.hw10.Task2.CacheProxy;
import edu.hw10.Task2.FibCalculator;
import edu.hw10.Task2.FibCalculatorImpl;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test void cacheProxy_FileIsNotEmpty_Test() throws IOException {
        //Arrange
        File file = new File("src/main/resources/cache.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter out = new PrintWriter(fileWriter);
        FibCalculator proxy = CacheProxy.create(new FibCalculatorImpl(), FibCalculator.class, file);

        //Act
        proxy.fib(5);
        out.close();

        //Assert
        assertThat(file).isNotEmpty();
    }
}
