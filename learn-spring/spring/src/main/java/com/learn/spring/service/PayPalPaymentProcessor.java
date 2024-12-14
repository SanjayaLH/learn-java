package com.learn.spring.service;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PayPalPaymentProcesser implements PaymentProcesser {
    @Override
    public void processPayment() {
        System.out.println("Processing paypal payment..");
    }
}
