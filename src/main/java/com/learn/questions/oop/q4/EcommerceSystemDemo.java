package com.learn.questions.oop.q4;

public class EcommerceSystemDemo {
    public static void main(String[] args) {
        double originalPrice = 100.00;

        Discount flatRateDiscount = new FlatRateDiscount(0.2);
        System.out.println("Flat Rate Discount price: " + flatRateDiscount.discount(originalPrice));

        Discount percentageBasedDiscount = new PercentageBasedDiscount(0.3);
        System.out.println("Percentage Based Discount price: " + percentageBasedDiscount.discount(originalPrice));

        Discount noDiscount = new NoDiscount();
        System.out.println("Price with no discount: " + noDiscount.discount(originalPrice));

    }
}
