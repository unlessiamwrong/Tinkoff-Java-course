package edu.hw8;

import edu.hw8.Task3.HackMultiThread;
import edu.hw8.Task3.HackSingleThread;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    private final Map<String, String> dataBase = Map.of(
        "a.v.petrov", "83cd3d8fb5b3ca7ca9af183096ef124a",
        "v.v.belov", "8030e98debc079fafb8c5de8efb1d0ed",
        "a.s.ivanov", "b2a2b5165c591698f26a403060f6ca9e",
        "k.p.maslov", "60d6f2142fc537d7c2c7b11c1b23a48f"
        );

    @Test
    void hack_St_ReturnsNotNull_Test(){
        //Arrange
        var st = new HackSingleThread(dataBase);

        //Act
        st.run();
        HashMap<String, String> result = st.result;


        //Assert
        assertThat(result).isNotNull();

    }

    @Test
    void hack_Mt_ReturnsNotNull_Test() throws InterruptedException {
        //Arrange
        var mt = new HackMultiThread(dataBase, 10);

        //Act
        mt.run();
        ConcurrentHashMap<String, String> result = mt.result;

        //Assert
        assertThat(result).isNotNull();

    }

}
