package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Creation of Object Test")
    void callingInfo_GetClassAndMethodeNames_Test() {
        //Arrange
        CallingInfo tempObject = CallingInfo.callingInfo();

        //Act
        String resultOne = tempObject.className();
        String resultTwo = tempObject.methodName();

        //Assert
        assertThat(resultOne).isEqualTo("edu.hw2.Task4Test");
        assertThat(resultTwo).isEqualTo("callingInfo_GetClassAndMethodeNames_Test");
    }
}
