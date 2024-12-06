package com.learn.networkprogramming;

import java.io.*;
import java.net.*;

public class HTTPServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("HTTP Server is running on port " + port);

        while (true) {
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String line;
                while (!(line = in.readLine()).isEmpty()) {
                    System.out.println(line);
                }

                String httpResponse = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Length: 13\r\n" +
                        "\r\n" +
                        "Hello, HTTP!";
                out.println(httpResponse);
            }
        }
    }
}
