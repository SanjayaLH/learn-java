package com.learn.questions.oop.q1;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void validatePayment() {
        System.out.println("Validating Credit Card payment");
    }

    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Processing payment with amount:" + amount);
    }
}
