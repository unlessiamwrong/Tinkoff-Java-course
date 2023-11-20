package edu.hw7;

import edu.hw7.Task3.Cache;
import edu.hw7.Task3.Person;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    void cache_ReturnsNotNull_Test() throws InterruptedException {
        var result = Cache.run();

        assertThat(result).isNotNull();
    }

    @Test
    void cache_ReturnContainsPerson_Test() throws InterruptedException {
        var result = Cache.run();

        assertThat(result.getFirst()).isInstanceOf(Person.class);
    }
}
