package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {

    private final static Logger LOGGER = LogManager.getLogger();
    private static final int BUFFER_SIZE = 1024;

    public static void clientRun(int port) {
        try {
            InetAddress hostIP = InetAddress.getLocalHost();
            InetSocketAddress address = new InetSocketAddress(hostIP, port);
            SocketChannel client = SocketChannel.open(address);

            String input = readInput();
            while (!input.isEmpty()) {
                ByteBuffer requestBuffer = ByteBuffer.allocate(BUFFER_SIZE);
                requestBuffer.put(input.getBytes());
                requestBuffer.flip();
                client.write(requestBuffer);

                ByteBuffer responseBuffer = ByteBuffer.allocate(BUFFER_SIZE);
                client.read(responseBuffer);
                String response = new String(responseBuffer.array()).trim();
                message(response);
                input = readInput();
            }
            client.close();
        } catch (IOException e) {
            message(e.getMessage());

        }
    }

    public static String readInput() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {

            return bufferedReader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void message(String message) {
        LOGGER.info(message);
    }
}
