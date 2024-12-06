package com.learn.questions.oop.q1;

import java.math.BigDecimal;

public class PaymentService {
    public void processUserPayment(PaymentProcessor processor, BigDecimal amount) {
        processor.validatePayment();
        processor.processPayment(amount);
    }

    public static void main(String[] args) {
        PaymentProcessor cardPayment = new CreditCardPayment();
        PaymentService service = new PaymentService();
        service.processUserPayment(cardPayment, BigDecimal.valueOf(10.20));

        PaymentProcessor payPal = new PayPalPayment();
        service.processUserPayment(payPal, BigDecimal.valueOf(20.10));
    }
}
