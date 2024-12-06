package com.learn.networkprogramming;

import java.io.*;
import java.net.*;

public class EnhancedTCPClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            String input;
            while (true) {
                System.out.println("Enter a command (HELLO, TIME, or EXIT): ");
                input = console.readLine();
                if (input.equalsIgnoreCase("EXIT")) {
                    break;
                }
                out.println(input);
                System.out.println("Server response: " + in.readLine());
            }
        }
    }
}
