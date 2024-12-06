package com.learn.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Refactor the following imperative code into a declarative form using streams
 */
public class RefactorExercise3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Achi");

        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name.toUpperCase());
            }
        }
        names.stream()
                .filter(name1 -> name1.startsWith("A"))
                .map(name1 -> name1.toUpperCase())
                .forEach(System.out::println);
    }
}
