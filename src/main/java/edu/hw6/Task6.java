package edu.hw6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber", "RegexpSinglelineJava", "MultipleStringLiterals", "EmptyBlock"})
public class Task6 {
    public static class PortScanner {

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";

        private final static Logger LOGGER = LogManager.getLogger();
        private static final File CLOSED_PORTS = new File("closedPorts.txt");
        static Map<Integer, String> ports = Map.of(
            135, "EPMAP",
            137, "Служба имен NetBIOS",
            445, "Microsoft-DS Active Directory",
            1900, "Simple Service Discovery Protocol (SSDP)",
            17500, "Dropbox"
        );

        static void checkPortTCP(int port) throws IOException {
            try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            } catch (IOException e) {
                PrintWriter out = new PrintWriter(new FileWriter(CLOSED_PORTS, true));
                out.print("TCP " + port + " CLOSED" + "\n");
                out.close();
                LOGGER.info(ANSI_RED + "TCP " + port + " CLOSED" + ANSI_RESET);
            }

        }

        static void checkPortUDP(int port) throws IOException {
            try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            } catch (IOException e) {
                PrintWriter out = new PrintWriter(new FileWriter(CLOSED_PORTS, true));
                out.print("UDP " + port + " CLOSED" + "\n");
                out.close();
                LOGGER.info(ANSI_RED + "UDP " + port + " CLOSED" + ANSI_RESET);
            }

        }

        public static void scanPorts() throws IOException {
            for (int port = 0; port <= 49151; ++port) {
                checkPortTCP(port);
                checkPortUDP(port);
            }
        }
    }
}
