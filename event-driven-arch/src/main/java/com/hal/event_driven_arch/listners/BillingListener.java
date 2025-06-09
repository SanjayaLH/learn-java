package com.hal.event_driven_arch.listners;

import com.hal.event_driven_arch.dto.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BillingListener {

    @RabbitListener(queues = "orders.billing.queue")
    public void bill(Order order) {
        System.out.println("💳 Billing customer " + order.getCustomerId() +
                " for $" + order.getTotalAmount());
    }
}