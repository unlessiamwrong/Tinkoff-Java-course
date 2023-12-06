package edu.project3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogAnalyzerTest {

    Path pathAdoc = Path.of("src/main/resources/logReport.adoc");
    Path pathMd = Path.of("src/main/resources/logReport.adoc");

    @Test
    void formatAdoc_CreatesAdoc_Test() throws IOException {
        //Arrange
        Path path = pathAdoc;
        File file = path.toFile();

        //Act
        LogAnalyzer.analyze(new String[] {"java", "-jar", "nginx-log-stats.jar", "--path",
            "src/main/resources/logs.txt", "--from", "2010-08-31", "--format", "adoc"});

        //Assert
        assertThat(file).isFile();
    }

    @Test
    void formatMd_CreatesMd_Test() throws IOException {
        //Arrange
        Path path = pathMd;
        File file = path.toFile();

        //Act
        LogAnalyzer.analyze(new String[] {"java", "-jar", "nginx-log-stats.jar", "--path",
            "src/main/resources/logs.txt", "--from", "2010-08-31", "--format", "markdown"});

        //Assert
        assertThat(file).isFile();
    }

    @Test
    void formatMd_FileContainsContent_Test() throws IOException {
        //Arrange
        Path path = pathMd;

        //Act
        LogAnalyzer.analyze(new String[] {"java", "-jar", "nginx-log-stats.jar", "--path",
            "src/main/resources/logs.txt", "--from", "2010-08-31", "--format", "markdown"});

        //Assert
        assertThat(Files.size(path)).isGreaterThan(10);

    }

    @Test
    void formatAdoc_FileContainsContent_Test() throws IOException {
        //Arrange
        Path path = pathAdoc;

        //Act
        LogAnalyzer.analyze(new String[] {"java", "-jar", "nginx-log-stats.jar", "--path",
            "src/main/resources/logs.txt", "--from", "2010-08-31", "--format", "adoc"});

        //Assert
        assertThat(Files.size(path)).isGreaterThan(10);

    }
}
