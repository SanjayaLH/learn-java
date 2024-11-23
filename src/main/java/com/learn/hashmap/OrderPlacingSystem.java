package com.learn.hashmap;

import java.util.*;

/**
 * Advanced Real-World Problem: Order Fulfillment System
 * Problem Statement:
 * You are tasked with implementing an Order Fulfillment System for an e-commerce platform.
 * The system processes incoming orders and maintains a record of customer orders using a HashMap.
 * Each customer can have multiple orders stored as a list. The system should support the following operations:
 * <p>
 * 1. Add a new order for a customer: If the customer already exists, add the order to their list.
 * If the customer does not exist, create a new entry with the customer's ID and their order.
 * <p>
 * 2. Retrieve all orders for a customer: Retrieve the list of orders for a specific customer.
 * <p>
 * 3. Check if a customer exists: Check if a specific customer ID is already in the system.
 * <p>
 * 4. Add a default order for a customer if absent: If the customer ID does not exist, add a default order (e.g., "Welcome Package").
 * <p>
 * 5. Update the last order's status: For a given customer ID, update the status of their most recent order. If no order exists, do nothing.
 */
public class OrderPlacingSystem {

    private Map<String, List<Order>> ordersMap;

    public OrderPlacingSystem() {
        ordersMap = new HashMap<>();
    }

    public void addOrderForCustomer(String customerId, Order order) {
        boolean isExist = ordersMap.containsKey(customerId);
        if (!isExist) {
            List<Order> orderList = new ArrayList<>();
            orderList.add(order);
            ordersMap.put(customerId, orderList);
        } else {
            List<Order> existingOrderList = ordersMap.get(customerId);
            existingOrderList.add(order);
            ordersMap.put(customerId, existingOrderList);
        }
        System.out.println(ordersMap);
        System.out.println(ordersMap.size());
    }

    public void listOrdersForCustomer(String customerId) {
        List<Order> existingOrders = ordersMap.get(customerId);
        System.out.println("Customer Id:" + customerId + ": " + existingOrders);
    }

    public void isCustomerExist(String customerId) {
        boolean isExist = ordersMap.containsKey(customerId);
        System.out.println("Is this customer exist: " + isExist);
    }

    public void updateMostResentOrderStatus(String customerId, String newStatus) {
        List<Order> existingOrders = ordersMap.get(customerId);

        Order mostResentOrder = existingOrders.get(existingOrders.size() - 1);

        System.out.println("Customer Id:" + customerId);
        System.out.println("Most recent order details: " + mostResentOrder);

        mostResentOrder.setStatus(newStatus);
        System.out.println("Most recent order details after update: " + mostResentOrder);
    }

    public static void main(String[] args) {
        OrderPlacingSystem orderPlacingSystem = new OrderPlacingSystem();

        orderPlacingSystem.addOrderForCustomer("001", new Order("b1", "bag", "s1"));
        orderPlacingSystem.addOrderForCustomer("002", new Order("p1", "pen", "s2"));
        orderPlacingSystem.addOrderForCustomer("002", new Order("p1", "pen", "s1"));
        orderPlacingSystem.addOrderForCustomer("003", new Order("b2", "ball", "s1"));

        orderPlacingSystem.listOrdersForCustomer("002");
        orderPlacingSystem.isCustomerExist("004");
        orderPlacingSystem.updateMostResentOrderStatus("003", "s2");
    }
}
