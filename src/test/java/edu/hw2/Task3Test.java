package edu.hw2;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Connection.FaultyConnection;
import edu.hw2.Task3.Connection.StableConnection;
import edu.hw2.Task3.ConnectionManager.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManager.FaultyConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("DefaultConnectionManager Test")
    void connection_DefaultConnectionManager_Test() {
        //Arrange
        DefaultConnectionManager tempObject = new DefaultConnectionManager();

        //Act
        Connection result = tempObject.getConnection();

        //Assert
        assertThat(result).isInstanceOf(StableConnection.class);

    }

    @Test
    @DisplayName("FaultyConnectionManager Test")
    void connection_FaultyConnectionManager_Test() {
        //Arrange
        FaultyConnectionManager tempObject = new FaultyConnectionManager();

        //Act
        Connection result = tempObject.getConnection();

        //Assert
        assertThat(result).isInstanceOf(FaultyConnection.class);
    }
}
