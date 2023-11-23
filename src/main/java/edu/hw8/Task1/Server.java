package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int BUFFER_SIZE = 1024;
    private static Selector selector = null;

    public static void main(String[] args) {

        try {
            int port = 10245;
            InetAddress hostIP = InetAddress.getLocalHost();
            selector = Selector.open();
            ServerSocketChannel socket = ServerSocketChannel.open();
            ServerSocket serverSocket = socket.socket();
            InetSocketAddress address = new InetSocketAddress(hostIP, port);
            serverSocket.bind(address);
            socket.configureBlocking(false);
            int ops = socket.validOps();
            socket.register(selector, ops, null);
            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> i = selectedKeys.iterator();
                while (i.hasNext()) {
                    SelectionKey key = i.next();
                    if (key.isAcceptable()) {
                        processAcceptEvent(socket);
                    } else if (key.isReadable()) {
                        processReadEvent(key);
                    }
                    i.remove();
                }
            }

        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    private static void processAcceptEvent(ServerSocketChannel socket) throws IOException {
        SocketChannel client = socket.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private static void processReadEvent(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer requestBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        client.read(requestBuffer);
        String request = new String(requestBuffer.array()).trim();

        if (!request.isEmpty()) {
            String value = request.toUpperCase() + ": " + DataBase.get(request);
            ByteBuffer responseBuffer = ByteBuffer.allocate(BUFFER_SIZE);
            responseBuffer.put(value.getBytes());
            responseBuffer.flip();
            client.write(responseBuffer);
        } else {
            client.close();
        }
    }

}

