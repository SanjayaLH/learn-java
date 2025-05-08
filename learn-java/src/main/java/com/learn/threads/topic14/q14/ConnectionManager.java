package com.learn.threads.topic14.q14;

import java.util.concurrent.BlockingQueue;

public class ConnectionManager {
    private static final int NUM_HANDLERS = 3;
    private static final int NUM_CLIENTS = 5;
    private static final Object lock = new Object();
    private static int completedInitializers = 0;

    public static void main(String[] args) {
        ThreadGroup threadGroupHandler = new ThreadGroup("Handler-Group");
        for (int i = 1; i <= NUM_HANDLERS; i++) {
            final int id = i;
            Thread connectionHandler = new Thread(threadGroupHandler, () -> {
                try {
                    Thread.sleep(1000 + id * 200); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                synchronized (lock) {
                    completedInitializers++;
                    System.out.println("Service " + id + " initialized (Group: " +
                            Thread.currentThread().getThreadGroup().getName() + ")");
                    if (completedInitializers == NUM_HANDLERS) {
                        lock.notifyAll(); // Notify all waiting clients
                    }
                }
            }, "Handler-Group t-" + i);
            connectionHandler.start();
        }

        for (int i = 1; i <= NUM_CLIENTS; i++) {
            final int clientId = i;
            new Thread(() -> {
                synchronized (lock) {
                    while (completedInitializers < NUM_HANDLERS) {
                        try {
                            System.out.println("Client-" + clientId + " waiting for services...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Client-" + clientId + " is connected and being served.");
                }
            }, "Client-" + clientId).start();
        }

        new Thread(() -> {
            while (threadGroupHandler.activeCount() > 0) {
                System.out.println("Active handler threads: " + threadGroupHandler.activeCount());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("All handler threads have completed.");
        }, "Monitor").start();

    }
}
