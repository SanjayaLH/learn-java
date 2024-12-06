package com.learn.questions.oop.q1;

import java.math.BigDecimal;

public interface PaymentProcessor {
    /**
     * Validate payment information
     */
    void validatePayment();

    /**
     * Processing the payments
     */
    void processPayment(BigDecimal amount);
}
