package edu.hw2.Task3.Connection;

import edu.hw2.Task3.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public class FaultyConnection implements Connection {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        boolean chanceToFail = (Math.random() * 10) > 4;
        if (chanceToFail) {
            throw new ConnectionException("ConnectionError");
        }
        LOGGER.info("OK");
    }

    @Override
    public void close() {
        LOGGER.info("Connection closed");

    }
}
