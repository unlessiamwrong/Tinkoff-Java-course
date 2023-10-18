package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String msg) {
        super(msg);

    }

    public ConnectionException(String msg, Throwable cause) {
        super(msg, cause);

    }

}
