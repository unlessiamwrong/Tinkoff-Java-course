package edu.hw7;

import edu.hw7.Task3.Cache;
import edu.hw7.Task3.RWLCache;
import edu.hw7.Task3.Person;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    void cache_RWLCache_ReturnNotNull_Test() throws InterruptedException {
        var resultOne = Cache.run();
        var resultTwo = RWLCache.run();

        assertThat(resultOne).isNotNull();
        assertThat(resultTwo).isNotNull();
    }

    @Test
    void cache_RWLCache_ReturnedValueContainsPerson_Test() throws InterruptedException {
        var resultOne = Cache.run();
        var resultTwo = RWLCache.run();

        assertThat(resultOne.getFirst()).isInstanceOf(Person.class);
        assertThat(resultTwo.getFirst()).isInstanceOf(Person.class);
    }
}
