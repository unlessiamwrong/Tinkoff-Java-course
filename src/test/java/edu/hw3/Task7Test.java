package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task7Test {

    @Test
    void comparator_AcceptNull_Test() {
        //Arrange
        TreeMap<String, String> tree = new TreeMap<>(new Task7<>());

        //Act
        tree.put(null, "test");

        //Assert
        assertThat(tree.containsKey(null)).isTrue();
    }
}
