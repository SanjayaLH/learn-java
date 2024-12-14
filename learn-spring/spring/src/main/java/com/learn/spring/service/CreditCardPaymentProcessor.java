package com.learn.spring.service;

import org.springframework.stereotype.Component;

@Component("card")
public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment..");
    }
}
