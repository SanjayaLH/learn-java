package com.learn.threads.q4;

import java.util.LinkedList;
import java.util.Queue;

class ConnectionPool {
    private final Queue<NetworkConnection> availableConnections;
    private final int maxSize;

    public ConnectionPool(int size) {
        this.maxSize = size;
        this.availableConnections = new LinkedList<>();
       /* for (int i = 0; i < size; i++) {
            availableConnections.add(new NetworkConnection());
        }*/
    }

    public synchronized NetworkConnection acquireConnection() throws InterruptedException {
        while (availableConnections.isEmpty()) {
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName());
            wait();//wait until connection create in the queue
        }
        NetworkConnection acquiredConnection = availableConnections.poll();
        System.out.println("connection acquired" + acquiredConnection);
        return acquiredConnection;
    }

    public synchronized void releaseConnection(NetworkConnection connection) {
        if (connection != null) {
            System.out.println("connection released" + connection);
            availableConnections.offer(connection);
            notifyAll();
        }
    }
}
