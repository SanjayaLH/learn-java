package com.learn.questions.oop.q2;

public class OrderService {
    private final Logger logger;

    // Constructor Injection
    public OrderService(Logger logger) {
        this.logger = logger;
    }

    public void placeOrder(String orderId) {
        System.out.println("Placing order: " + orderId);
        logger.log("Order placed: " + orderId);
    }
}
