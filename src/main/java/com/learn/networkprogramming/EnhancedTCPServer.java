package com.learn.networkprogramming;

import java.io.*;
import java.net.*;

public class EnhancedTCPServer {
    public static void main(String[] args) throws IOException {
        int port = 12345;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port);

        try (Socket socket = serverSocket.accept()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String command;
            while ((command = in.readLine()) != null) {
                if (command.equalsIgnoreCase("HELLO")) {
                    out.println("Hello, Client!");
                } else if (command.equalsIgnoreCase("TIME")) {
                    out.println("Current Time: " + new java.util.Date());
                } else {
                    out.println("Unknown command: " + command);
                }
            }
        }
    }
}
