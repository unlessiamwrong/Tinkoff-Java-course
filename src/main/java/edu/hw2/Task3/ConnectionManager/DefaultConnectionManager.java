package edu.hw2.Task3.ConnectionManager;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Connection.FaultyConnection;
import edu.hw2.Task3.Connection.StableConnection;

@SuppressWarnings("MagicNumber")
public class DefaultConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        boolean chanceToFail = (Math.random() * 10) > 4;
        if (chanceToFail) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
