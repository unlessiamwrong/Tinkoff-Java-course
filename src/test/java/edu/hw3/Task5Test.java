package edu.hw3;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @Test
    public void parseContacts_BasicCaseOne_Test() {
        //Arrange
        var testCase = new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        var sortType = "DESC";

        //Act
        var result = Task5.parseContacts(testCase, sortType);
        var expectedResult = new String[] {"Carl Gauss", "Leonhard Euler", "Paul Erdos"};

        //Assert
        assertThat(result).isEqualTo(Arrays.asList(expectedResult));
    }

    @Test
    public void parseContacts_BasicCaseTwo_Test() {
        //Arrange
        var testCase = new String[] {"Paul Ezdos", "Leonhard Euler", "Carl Gauss"};
        var sortType = "DESC";

        //Act
        var result = Task5.parseContacts(testCase, sortType);
        var expectedResult = new String[] {"Carl Gauss", "Paul Ezdos", "Leonhard Euler"};

        //Assert
        assertThat(result).isEqualTo(Arrays.asList(expectedResult));
    }
}
