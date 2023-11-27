package edu.hw7;

import edu.hw7.Task3.Cache;
import edu.hw7.Task3.Person;
import edu.hw7.Task3.RWLCache;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    void cache_ReturnsNotNull_Test() throws InterruptedException {
        //Arrange
        Cache cache = new Cache();
        List<Person> result = new ArrayList<>();
        CountDownLatch cdl = new CountDownLatch(3);

        //Act
        Thread[] threadsAdd = new Thread[10];
        for (int i = 0; i < threadsAdd.length; i++) {
            int finalI = i;
            threadsAdd[i] = new Thread(() -> {
                cdl.countDown();
                Person person = new Person(finalI, "n" + finalI, "a" + finalI, "p" + finalI);
                cache.add(person);
            });
            threadsAdd[i].start();
        }

        Thread[] threadsGetByName = new Thread[10];
        for (int i = 0; i < threadsGetByName.length; i++) {
            int finalI = i;
            threadsGetByName[i] = new Thread(() -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Person person = cache.findById(finalI);
                if (person != null) {
                    result.add(cache.findByName(person.name()));
                }
            });
            threadsGetByName[i].start();
        }

        Thread[] threadsGetByAddress = new Thread[10];
        for (int i = 0; i < threadsGetByAddress.length; i++) {
            int finalI = i;
            threadsGetByAddress[i] = new Thread(() -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Person person = cache.findById(finalI);
                if (person != null) {
                    result.add(cache.findByAddress(person.address()));
                }
            });
            threadsGetByAddress[i].start();
        }
        for (int i = 0; i < threadsAdd.length; i++) {
            threadsAdd[i].join();
            threadsGetByName[i].join();
            threadsGetByAddress[i].join();
        }

        //Assert
        assertThat(result).isNotNull();
    }

    @Test
    void RWLCache_ReturnsNotNull_Test() throws InterruptedException {
        //Arrange
        RWLCache rwlCache = new RWLCache();
        List<Person> result = new ArrayList<>();
        CountDownLatch cdl = new CountDownLatch(3);

        //Act
        Thread[] threadsAdd = new Thread[10];
        for (int i = 0; i < threadsAdd.length; i++) {
            int finalI = i;
            threadsAdd[i] = new Thread(() -> {
                cdl.countDown();
                Person person = new Person(finalI, "n" + finalI, "a" + finalI, "p" + finalI);
                rwlCache.add(person);
            });
            threadsAdd[i].start();
        }

        Thread[] threadsGetByName = new Thread[10];
        for (int i = 0; i < threadsGetByName.length; i++) {
            int finalI = i;
            threadsGetByName[i] = new Thread(() -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Person person = rwlCache.findById(finalI);
                if (person != null) {
                    result.add(rwlCache.findByName(person.name()));
                }
            });
            threadsGetByName[i].start();
        }

        Thread[] threadsGetByAddress = new Thread[10];
        for (int i = 0; i < threadsGetByAddress.length; i++) {
            int finalI = i;
            threadsGetByAddress[i] = new Thread(() -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Person person = rwlCache.findById(finalI);
                if (person != null) {
                    result.add(rwlCache.findByAddress(person.address()));
                }
            });
            threadsGetByAddress[i].start();
        }
        for (int i = 0; i < threadsAdd.length; i++) {
            threadsAdd[i].join();
            threadsGetByName[i].join();
            threadsGetByAddress[i].join();
        }

        //Assert
        assertThat(result).isNotNull();
    }

}
