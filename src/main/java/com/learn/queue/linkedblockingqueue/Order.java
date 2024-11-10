package com.learn.queue.linkedblockingqueue;

class Order {
    private final String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
