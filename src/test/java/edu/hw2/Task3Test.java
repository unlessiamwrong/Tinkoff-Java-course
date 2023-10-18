package edu.hw2;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Connection.FaultyConnection;
import edu.hw2.Task3.ConnectionManager.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManager.FaultyConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("DefaultConnectionManager Test")
    void connection_DefaultConnectionManager_Test() {
        DefaultConnectionManager tempObject = new DefaultConnectionManager();
        assertThat(tempObject.getConnection()).isInstanceOf(Connection.class);
    }

    @Test
    @DisplayName("FaultyConnectionManager Test")
    void connection_FaultyConnectionManager_Test() {
        FaultyConnectionManager tempObject = new FaultyConnectionManager();
        assertThat(tempObject.getConnection()).isInstanceOf(FaultyConnection.class);
    }
}
