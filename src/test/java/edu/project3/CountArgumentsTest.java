package edu.project3;

import edu.project3.Utility.CountArguments;
import edu.project3.Utility.General;
import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CountArgumentsTest {

    private final Path path = Path.of("src/test/resources/logsTest.txt");
    private final File file = path.toFile();
    private final LocalDate date = LocalDate.parse("2010-08-31");
    private final LogRecord logRecord = new LogRecord(".md", path, date);

    private final General general = new General(logRecord, file);

    private final CountArguments countArguments = new CountArguments(general.logs);

    @Test
    void endPoints_CountCorrectly_Test() {
        //Arrange
        long expected = 6250;

        //Act
        Map<String, Integer> endPoints = countArguments.endPointCount();
        long result = endPoints.get("/downloads/product_2");

        //Assert
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void statusCodes_CountCorrectly_Test() {
        //Arrange
        long expected = 11026;

        //Act
        Map<String, Integer> statusCodes = countArguments.statusCodeCount();
        long result = statusCodes.get("404");

        //Assert
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void httpMethods_CountCorrectly_Test() {
        //Arrange
        long expected = 16414;

        //Act
        Map<String, Integer> httpMethods = countArguments.httpMethodCount();
        long result = httpMethods.get("GET");

        //Assert
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void ipAddresses_CountCorrectly_Test() {
        //Arrange
        long expected = 800;

        //Act
        Map<String, Integer> ipAddresses = countArguments.ipAddressCount();
        long result = ipAddresses.get("216.46.173.126");

        //Assert
        assertThat(result).isEqualTo(expected);

    }
}
