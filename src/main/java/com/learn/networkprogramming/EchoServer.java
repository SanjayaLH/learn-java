package com.learn.networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public void serverEcho() {
        ServerSocket serverSocket = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader readClientInputStream = null;
        PrintWriter msgEcoToClientWriter = null;
        try {
            int PORT = 4242;
            serverSocket = new ServerSocket(PORT);
            System.out.println("Echo Server is running on port: " + serverSocket.getLocalPort());
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
            readClientInputStream = new BufferedReader(inputStreamReader);
            msgEcoToClientWriter = new PrintWriter(clientSocket.getOutputStream());

            String clientMsg;
            do {
                //Get the client message
                clientMsg = readClientInputStream.readLine();
                System.out.println("Received from client: " + clientMsg);

                // Echo the message back to the client
                msgEcoToClientWriter.println(clientMsg);
                msgEcoToClientWriter.flush();
            } while (!clientMsg.equals("exit"));// Terminate the connection when client send the 'exit'
            System.out.println("Client disconnected.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                msgEcoToClientWriter.close();
                readClientInputStream.close();
                inputStreamReader.close();
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Error while closing the connections " + e);
            }
        }
    }

    public static void main(String[] args) {
        EchoServer echoServer = new EchoServer();
        echoServer.serverEcho();
    }
}
