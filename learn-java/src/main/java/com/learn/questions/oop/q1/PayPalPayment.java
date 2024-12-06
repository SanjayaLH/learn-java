package com.learn.questions.oop.q1;

import java.math.BigDecimal;

public class PayPalPayment implements PaymentProcessor {

    @Override
    public void validatePayment() {
        System.out.println("Validate PayPal payment");
    }

    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("PayPal payment with amount:" + amount);
    }
}
