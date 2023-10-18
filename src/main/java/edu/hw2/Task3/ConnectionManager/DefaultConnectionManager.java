package edu.hw2.Task3.ConnectionManager;

import edu.hw2.Task3.Connection.Connection;

import edu.hw2.Task3.Connection.StableConnection;

@SuppressWarnings("MagicNumber")
public class DefaultConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        return new StableConnection();
    }
}
