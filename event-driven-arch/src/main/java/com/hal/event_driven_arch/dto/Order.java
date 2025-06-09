package com.hal.event_driven_arch.dto;

import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private List<String> itemIds;
    private double totalAmount;

    public Order(String id, String customerId, List<String> itemIds, double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.itemIds = itemIds;
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", itemIds=" + itemIds +
                ", totalAmount=" + totalAmount +
                '}';
    }
}