package com.learn.spring.service;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Processing paypal payment..");
    }
}
