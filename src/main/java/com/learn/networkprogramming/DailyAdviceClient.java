package com.learn.networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public void go() {
        try {
            Socket chatSocket = new Socket("127.0.0.1", 4242);

            InputStreamReader inputStreamReader = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String advice = bufferedReader.readLine();
            System.out.println("Today u should: " + advice);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EchoClient echoClient = new EchoClient();
        echoClient.go();
    }
}
