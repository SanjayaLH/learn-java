package com.learn.streams;

@FunctionalInterface
interface Discount {
    double apply(double price);
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        Discount noDiscount = price -> price;
        Discount tenPercentDiscount = price -> price * 0.9;

        double originalPrice = 100.0;
        System.out.println("Price with no discount: " + noDiscount.apply(originalPrice));
        System.out.println("Price with 10% discount: " + tenPercentDiscount.apply(originalPrice));
    }
}
