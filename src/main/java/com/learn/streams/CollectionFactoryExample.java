package com.learn.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactoryExample {
    public static void main(String[] args) {
        //Immutable List using java 9 Factory
        List<String> fruits = List.of("Apple", "Banana", "Cherry");

        //Immutable Set using java 9 Factory
        Set<String> colors = Set.of("Red", "Green", "Blue");

        //Immutable Map using java 9 Factory
        Map<String, Integer> fruitCalories = Map.of("Apple", 95, "Banana", 105, "Cherry", 50);

        System.out.println("Fruits : " + fruits);
        System.out.println("Colors : " + colors);
        System.out.println("Fruit Calories : " + fruitCalories);
    }
}
