package com.learn.questions.oop.q4;

public class FlatRateDiscount implements Discount {
    private double rate;

    public FlatRateDiscount(double fRate) {
        this.rate = fRate;
    }

    @Override
    public double discount(double price) {
        return price - price * rate;
    }
}
