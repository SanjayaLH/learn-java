package com.learn.queue.linkedblockingqueue;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

class OrderProducer implements Runnable {
    private final LinkedBlockingQueue<Order> orderQueue;
    private final String producerId;

    public OrderProducer(LinkedBlockingQueue<Order> orderQueue, String producerId) {
        this.orderQueue = orderQueue;
        this.producerId = producerId;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) { // Each producer creates 5 orders
                Order order = new Order(UUID.randomUUID().toString()); // Unique order ID per producer
                if (orderQueue.size() == 10) {
                    System.out.println("Queue is full");
                }
                orderQueue.put(order); // Blocks if the queue is full
                System.out.println("Producer " + producerId + " placed Order ID: " + order.getOrderId());
                Thread.sleep(100); // Simulating time taken to place an order
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
