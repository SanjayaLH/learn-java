package com.learn.questions.oop.q4;

public class Cart {
    private Discount discountStrategy;

    public Cart(Discount discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalAmount(double amount) {
        return discountStrategy.discount(amount);
    }
}
