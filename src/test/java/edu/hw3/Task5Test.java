package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @Test
    public void task5Test1() {
        //Arrange
        var testCase = new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        var sortType = "DESC";

        //Act
        var result = Task5.parseContacts(testCase, sortType);
        var expectedResult = new String[]{"Carl Gauss", "Paul Erdos", "Leonhard Euler"};

        //Assert
        assertThat(result).isEqualTo(Arrays.asList(expectedResult));
    }


    @Test
    public void task5Test2() {
        //Arrange
        var testCase = new String[]{"Paul Ezdos", "Leonhard Euler", "Carl Gauss"};
        var sortType = "DESC";

        //Act
        var result = Task5.parseContacts(testCase, sortType);
        var expectedResult = new String[]{"Carl Gauss", "Leonhard Euler", "Paul Ezdos"};

        //Assert
        assertThat(result).isEqualTo(Arrays.asList(expectedResult));
    }
}
