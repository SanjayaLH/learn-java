package com.learn.networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer2 {
        public static void main(String[] args) {
            int port = 12345;

            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Echo Server is running on port " + port);

                // Accept a connection from the client
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected!");

                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received from client: " + message);

                        // Echo the message back to the client
                        out.println("Echo: " + message);

                        // Terminate the connection if the client sends "exit"
                        if ("exit".equalsIgnoreCase(message)) {
                            System.out.println("Client disconnected.");
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error in server: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
