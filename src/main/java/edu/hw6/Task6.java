package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;

@SuppressWarnings({"MagicNumber", "RegexpSinglelineJava", "MultipleStringLiterals"})
public class Task6 {
    public static class PortScanner {

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";

        static Map<Integer, String> ports = Map.of(
            135, "EPMAP",
            137, "Служба имен NetBIOS",
            445, "Microsoft-DS Active Directory",
            1900, "Simple Service Discovery Protocol (SSDP)",
            17500, "Dropbox"
        );

        static void checkPortTCP(int port) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                String portDescription = ports.get(port);
                if (portDescription != null) {
                    System.out.println(ANSI_GREEN + "TCP " + port + " " + ports.get(port) + ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN + "TCP " + port + " UnknownUsage" + ANSI_RESET);
                }
            } catch (IOException e) {
                System.out.println(ANSI_RED + "TCP " + port + " CLOSED" + ANSI_RESET);
            }

        }

        static void checkPortUDP(int port) {
            try (DatagramSocket serverSocket = new DatagramSocket(port)) {
                String portDescription = ports.get(port);
                if (portDescription != null) {
                    System.out.println(ANSI_GREEN + "UDP " + port + " " + ports.get(port) + ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN + "UDP " + port + " UnknownUsage" + ANSI_RESET);
                }
            } catch (IOException e) {
                System.out.println(ANSI_RED + "UDP " + port + " CLOSED" + ANSI_RESET);
            }

        }

        public static void scanPorts() {
            for (int port = 0; port <= 49151; ++port) {
                checkPortTCP(port);
                checkPortUDP(port);
            }
        }
    }
}
