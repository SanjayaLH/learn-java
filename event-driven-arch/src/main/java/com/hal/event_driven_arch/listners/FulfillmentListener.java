package com.hal.event_driven_arch.listners;

import com.hal.event_driven_arch.dto.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FulfillmentListener {

    @RabbitListener(queues = "orders.fulfillment.queue")
    public void fulfill(Order order) {
        System.out.println("📦 Fulfilling order " + order.getId() +
                " for customer " + order.getCustomerId());
    }
}