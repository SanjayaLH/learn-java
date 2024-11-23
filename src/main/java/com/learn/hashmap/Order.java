package com.learn.hashmap;

class Order {
    private final String id;
    private final String type;
    private String status;

    public Order(String orderId, String orderType, String orderStatus) {
        this.id = orderId;
        this.type = orderType;
        this.status = orderStatus;
    }

    public String getOrderId() {
        return id;
    }

    public String getOrderType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
