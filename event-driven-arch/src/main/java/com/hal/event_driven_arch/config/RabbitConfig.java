package com.hal.event_driven_arch.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE = "orders.exchange";
    public static final String ROUTING_KEY = "orders.new";


    @Bean
    public Queue fulfillmentQueue() {
        return QueueBuilder.durable("orders.fulfillment.queue").build();
    }
    // Billing queue
    @Bean
    public Queue billingQueue() {
        return QueueBuilder.durable("orders.billing.queue").build();
    }

    @Bean
    public DirectExchange ordersExchange() {
        // durable, not auto-deleted
        return new DirectExchange(EXCHANGE, true, false);
    }

    @Bean
    public Binding bindFulfillment(Queue fulfillmentQueue, DirectExchange ordersExchange) {
        return BindingBuilder.bind(fulfillmentQueue).to(ordersExchange).with(ROUTING_KEY);
    }
    @Bean
    public Binding bindBilling(Queue billingQueue, DirectExchange ordersExchange) {
        return BindingBuilder.bind(billingQueue).to(ordersExchange).with(ROUTING_KEY);
    }
}

