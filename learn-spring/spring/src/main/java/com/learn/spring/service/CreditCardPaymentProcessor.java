package com.learn.spring.service;

import org.springframework.stereotype.Component;

@Component("card")
public class CreditCardPaymentProcesser implements PaymentProcesser {

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment..");
    }
}
