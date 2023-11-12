package edu.hw6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task5.HackerNews.hackerNewsTopStories;
import static edu.hw6.Task5.HackerNews.news;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    void hackerNewsTopStories_Test() throws IOException, URISyntaxException, InterruptedException {
        //Arrange
        Long expectedFirst = 38249214L;
        Long expectedLast = 38232052L;

        //Act
        List<Long> result = hackerNewsTopStories();

        //Assert
        assertThat(result.getFirst()).isEqualTo(expectedFirst);
        assertThat(result.getLast()).isEqualTo(expectedLast);
    }

    @Test
    void news_Test() throws IOException, URISyntaxException, InterruptedException {
        //Arrange
        String expected = "\"title\":\"Ship Shape\"";

        //Act
        String result = news(38249214);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
