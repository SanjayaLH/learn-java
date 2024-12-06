package com.learn.questions.oop.q4;

public class NoDiscount implements Discount {

    @Override
    public double discount(double price) {
        return price;
    }
}
