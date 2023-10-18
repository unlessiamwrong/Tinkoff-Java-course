package edu.hw2.Task3;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.ConnectionManager.ConnectionManager;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) {
        for (int attemptCount = 1; attemptCount <= maxAttempts; ++attemptCount) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (Exception e) {
                throw new ConnectionException("ConnectionError");
            }
        }
        throw new ConnectionException("Error. Too many attempts.");
    }
}
