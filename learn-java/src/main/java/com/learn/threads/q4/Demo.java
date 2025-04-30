package com.learn.threads.q4;

public class Demo {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(3);
        Runnable userTask = () -> {
            try {
                NetworkConnection connection = pool.acquireConnection();
                connection.connect();
                Thread.sleep(2000); // Simulate work
                connection.disconnect();
                pool.releaseConnection(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread user1 = new Thread(userTask);
        Thread user2 = new Thread(userTask);
        Thread user3 = new Thread(userTask);
        Thread user4 = new Thread(userTask);
        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
