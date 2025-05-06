package com.learn.threads.q4;

public class NetworkConnection {

        private static int counter = 0;
        private final int id;

        public NetworkConnection() {
            this.id = ++counter;
        }

        public void connect() {
            System.out.println("Connection " + id + " established.");
        }

        public void disconnect() {
            System.out.println("Connection " + id + " closed.");
        }

}
