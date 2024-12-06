package com.learn.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderPlacingSystemTest {

    private OrderPlacingSystem orderPlacingSystem;

    @BeforeEach
    public void setUp() {
        orderPlacingSystem = new OrderPlacingSystem();
    }

    @Test
    void shouldAddOrderForCustomer() {
        Order expectedOrder = new Order("ord01","REGULAR","PENDING");
        orderPlacingSystem.addOrderForCustomer("001", expectedOrder);
        List<Order> actualOrderList = orderPlacingSystem.listOrdersForCustomer("001");

        assertNotNull(actualOrderList);
        assertEquals(1, actualOrderList.size());
        assertEquals(expectedOrder, actualOrderList.get(0));
    }

    @Test
    void ifCustomerAlreadyExistOrderShouldAddToSameList() {
        Order expectedOrder1 = new Order("ord01","REGULAR","PENDING");
        Order expectedOrder2 = new Order("ord02","REGULAR","COMPLETED");
        orderPlacingSystem.addOrderForCustomer("001", expectedOrder1);
        orderPlacingSystem.addOrderForCustomer("001", expectedOrder2);
        List<Order> actualOrderList = orderPlacingSystem.listOrdersForCustomer("001");

        assertNotNull(actualOrderList);
        assertEquals(2, actualOrderList.size());
        assertEquals(expectedOrder1, actualOrderList.get(0));
        assertEquals(expectedOrder2, actualOrderList.get(1));


    }
}