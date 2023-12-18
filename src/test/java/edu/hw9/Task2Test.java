package edu.hw9;

import edu.hw9.Task2.DirSearch;
import edu.hw9.Task2.FileSearch;
import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test void dirSearch_ReturnsCorrect_Test() {
        //Arrange
        ForkJoinPool pool = new ForkJoinPool();
        File root = new File("src/main");

        //Act
        List<File> result = pool.invoke(new DirSearch(root));

        //Assert
        assertThat(result).isEmpty();

    }

    @Test void fileSearch_ReturnsCorrect_Test() {
        //Arrange
        ForkJoinPool pool = new ForkJoinPool();
        File root = new File("src/main/resources");
        long size = 3000;
        String extension = ".txt";

        //Act
        List<File> result = pool.invoke(new FileSearch(root, size, extension));

        //Assert
        assertThat(result.size()).isEqualTo(1);

    }
}
