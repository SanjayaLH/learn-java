package com.learn.streams;

/**
 * Create a Strategy Pattern to calculate shipping costs based on:
 * Standard Shipping: $10.
 * Express Shipping: $20.
 */
@FunctionalInterface
interface ShippingStrategy {
    double calculate(double weight);
}

public class StrategyPatternExcise4 {
    public static void main(String[] args) {
        ShippingStrategy standardShippingCost = weight -> weight * 10;
        ShippingStrategy expressdShippingCost = weight -> weight * 20;

        double itemWeight = 100.0;
        System.out.println("Cost for Standard Shipping: " + standardShippingCost.calculate(itemWeight));
        System.out.println("Cost for Express Shipping: " + expressdShippingCost.calculate(itemWeight));

    }
}
