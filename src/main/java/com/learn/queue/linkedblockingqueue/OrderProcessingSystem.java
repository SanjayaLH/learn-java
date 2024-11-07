package com.learn.queue.linkedblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class OrderProcessingSystem {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(10); // Limit queue size to 10

        Thread consumer = new Thread(new OrderConsumer(orderQueue, 1));
        consumer.start();

        Thread.sleep(3000);

        // Starting 3 producer threads
        for (int i = 1; i <= 3; i++) {
            new Thread(new OrderProducer(orderQueue, "producer " + i)).start();
        }

    }
}
