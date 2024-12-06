package com.learn.streams;

import java.util.HashMap;
import java.util.Map;

/**
 * Use a Map to track product sales. Write a program to:
 * Use merge to add or update product sales.
 * Use compute to apply discounts on products if their sales exceed a threshold.
 */
public class ProductSaleTrackingExercise {
    public static void main(String[] args) {
        Map<String, Integer> productSales = new HashMap<>();

        productSales.merge("Pencil", 1, Integer::sum);
        productSales.merge("Eraser", 1, Integer::sum);
        productSales.merge("Pencil", 2, Integer::sum);
        productSales.merge("Pen", 1, Integer::sum);

        System.out.println("Current sale: "+ productSales);

       //productSales.compute("Pencil", (k,v)-> v > 5 ? "d" : "nd");


    }
}
