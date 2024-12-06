package com.learn.networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient2 {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to Echo Server!");

            String message;
            while (true) {
                System.out.print("Enter message (type 'exit' to quit): ");
                message = consoleReader.readLine();

                // Send message to the server
                serverWriter.println(message);

                // Terminate if user types "exit"
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Disconnected from server.");
                    break;
                }

                // Read and print the server's response
                String response = serverReader.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            System.err.println("Error in client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
