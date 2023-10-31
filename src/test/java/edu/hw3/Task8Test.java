package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    void iterator_Integer_ReturnBackwards_Test() {
        //Arrange
        List<Integer> iterableList = List.of(1, 2, 3);
        Task8<Integer> tempObject = new Task8<>(iterableList);
        List<Integer> expectedResult = List.of(3, 2, 1);

        //Act
        List<Integer> result = new ArrayList<>();
        result.add(tempObject.next());
        result.add(tempObject.next());
        result.add(tempObject.next());

        //Assert
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    void iterator_String_ReturnBackwards_Test() {
        //Arrange
        List<String> iterableList = List.of("a", "b", "c");
        Task8<String> tempObject = new Task8<>(iterableList);
        List<String> expectedResult = List.of("c", "b", "a");

        //Act
        List<String> result = new ArrayList<>();
        result.add(tempObject.next());
        result.add(tempObject.next());
        result.add(tempObject.next());

        //Assert
        assertThat(result).isEqualTo(expectedResult);

    }
}
