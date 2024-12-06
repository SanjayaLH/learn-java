package com.learn.questions.oop.q4;

public class PercentageBasedDiscount implements Discount {
    private double rate;

    public PercentageBasedDiscount(double pRate) {
        this.rate = pRate;
    }

    @Override
    public double discount(double price) {
        return price - price * rate;
    }
}
