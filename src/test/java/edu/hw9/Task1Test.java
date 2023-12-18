package edu.hw9;

import edu.hw9.Task1.Stat;
import edu.hw9.Task1.StatsCollector;
import java.security.SecureRandom;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    SecureRandom random = new SecureRandom();
    double maxDouble = 1.7 * Math.pow(10, 308);
    double minDouble = -1.7 * Math.pow(10, 308);

    @Test void stats_AreNotEmpty_Test() {
        //Arrange
        StatsCollector collector = new StatsCollector();

        //Act
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> collector.push(
                "number" + finalI,
                new double[] {random.nextDouble(), random.nextDouble(), random.nextDouble()}
            ));
            thread.start();
        }

        //Assert
        assertThat(collector.stats().size()).isGreaterThan(1);

    }

    @Test void stats_CalculateCorrect_Test() {
        //Arrange
        StatsCollector collector = new StatsCollector();

        //Act
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> collector.push(
                "number" + finalI,
                new double[] {random.nextDouble(), random.nextDouble(), random.nextDouble()}
            ));
            thread.start();
        }
        Stat firstStat = collector.stats().getFirst();

        //Assert
        assertThat(firstStat.sum()).isGreaterThan(0.0);
        assertThat(firstStat.avg()).isGreaterThan(0.0);
        assertThat(firstStat.max()).isGreaterThan(minDouble);
        assertThat(firstStat.min()).isLessThan(maxDouble);

    }
}


