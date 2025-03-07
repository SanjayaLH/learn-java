package com.learn.questions.oop.q4;

public class EcommerceSystemDemo {
    public static void main(String[] args) {
        double originalPrice = 100.00;

        Cart cart = new Cart(new FlatRateDiscount(0.2));

        System.out.println("Flat Rate Discount price: " + cart.calculateFinalAmount(originalPrice));

       /* Discount percentageBasedDiscount = new PercentageBasedDiscount(0.3);
        System.out.println("Percentage Based Discount price: " + percentageBasedDiscount.discount(originalPrice));

        Discount noDiscount = new NoDiscount();
        System.out.println("Price with no discount: " + noDiscount.discount(originalPrice));*/

    }
}
