package com.learn.networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

    public void echo() {
        Socket echoSocket = null;
        PrintWriter msgToServer = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader readServerInputStream = null;
        Scanner scanner = null;
        try {
            String HOST = "127.0.0.1";
            int PORT = 4242;
            echoSocket = new Socket(HOST, PORT);
            System.out.println("Connected to Echo Server!");

            //Scanner use to get the console input
            scanner = new Scanner(System.in);

            msgToServer = new PrintWriter(echoSocket.getOutputStream(), true);
            inputStreamReader = new InputStreamReader(echoSocket.getInputStream());
            readServerInputStream = new BufferedReader(inputStreamReader);

            String userInput;
            do {
                System.out.print("Enter message(type 'exit' to quit) : ");
                //Get the console input
                userInput = scanner.nextLine();
                //Send message to the server
                msgToServer.println(userInput);

                //Get the server incoming messages and print
                String serverMsg = readServerInputStream.readLine();
                System.out.println("Server response: Echo: " + serverMsg);

            } while (!userInput.equals("exit")); // Terminate if user types "exit"
            System.out.println("Disconnected from server.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                readServerInputStream.close();
                inputStreamReader.close();
                msgToServer.close();
                scanner.close();
                echoSocket.close();
            } catch (IOException e) {
                System.err.println("Error while closing the resources " + e);
            }
        }
    }

    public static void main(String[] args) {
        EchoClient echoClient = new EchoClient();
        echoClient.echo();
    }
}
