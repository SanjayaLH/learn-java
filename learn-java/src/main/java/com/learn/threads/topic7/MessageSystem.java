package com.learn.threads.topic7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Sample code for
 * 7. Passing Messages
 */
public class MessageSystem {

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    public void send(String message) throws InterruptedException {
        queue.put(message);
    }

    public String receive() throws InterruptedException {
        return queue.take();
    }

    public static void main(String[] args) {
        MessageSystem system = new MessageSystem();
        Thread sender = new Thread(() -> {
            try {
                //System.out.println("Sender thread");
                system.send("Hello from Sender!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread receiver = new Thread(() -> {
            try {
                //System.out.println("Receiver thread");
                System.out.println("Received: " + system.receive());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        sender.start();
        receiver.start();
    }
}
