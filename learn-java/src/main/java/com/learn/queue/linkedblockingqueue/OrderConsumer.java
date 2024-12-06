package com.learn.queue.linkedblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

class OrderConsumer implements Runnable {
    private final LinkedBlockingQueue<Order> orderQueue;
    private final int consumerId;

    public OrderConsumer(LinkedBlockingQueue<Order> orderQueue, int consumerId) {
        this.orderQueue = orderQueue;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        System.out.println("Starting Consumer: " + consumerId);
        try {
            while (true) {
                if (orderQueue.isEmpty()) {
                    System.out.println("Queue is empty");
                }
                Order order = orderQueue.take(); // Blocks if the queue is empty
                System.out.println("Consumer " + consumerId + " processed Order ID: " + order.getOrderId());
                Thread.sleep(10000); // Simulating time taken to process an order
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
