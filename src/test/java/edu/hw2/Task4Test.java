package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Creation of Object Test")
    void callingInfo_GetClassAndMethodeNames_Test() {
        CallingInfo tempObject = CallingInfo.callingInfo();
        assertThat(tempObject.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(tempObject.methodName()).isEqualTo("callingInfo_GetClassAndMethodeNames_Test");
    }
}
