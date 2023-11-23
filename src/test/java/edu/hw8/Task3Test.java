package edu.hw8;

import edu.hw8.Task3.HackMultiThread;
import edu.hw8.Task3.HackSingleThread;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    void hack_Mt_IsFasterSt_Test() throws InterruptedException {
        //Arrange
        Map<String, String> dataBase = Map.of(
            "a.v.petrov", "83cd3d8fb5b3ca7ca9af183096ef124a",
            "v.v.belov", "8030e98debc079fafb8c5de8efb1d0ed",
            "a.s.ivanov", "b2a2b5165c591698f26a403060f6ca9e",
            "k.p.maslov", "60d6f2142fc537d7c2c7b11c1b23a48f"
        );
        var st = new HackSingleThread(dataBase);
        var mt = new HackMultiThread(dataBase, 10);

        //Act
        long executionTimeMt = countTimeMt(mt);
        long executionTimeSt = countTimeSt(st);

        //Assert
        assertThat(executionTimeSt).isGreaterThan(executionTimeMt);

    }

    private long countTimeSt(HackSingleThread st) {
        long startTime = System.nanoTime();
        st.run();
        long stopTime = System.nanoTime();
        return stopTime - startTime;
    }

    private long countTimeMt(HackMultiThread mt) throws InterruptedException {
        long startTime = System.nanoTime();
        mt.run();
        long stopTime = System.nanoTime();
        return stopTime - startTime;
    }
}
