package com.learn.questions.funcprog.q4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<String> productNames = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado", "cherry");

        //Approach one fail because you hardcoded the a and b inside the print statement.
        // If some other product name is there(eg:cherry) it will not print in the result
        List<String> startFromA = productNames.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
        List<String> startFromB = productNames.stream()
                .filter(s -> s.startsWith("b"))
                .collect(Collectors.toList());

        System.out.println("a->" + startFromA);
        System.out.println("b->" + startFromB);

        //Approach two correct
        Map<Character, List<String>> groupByLetters = productNames.stream()
                .collect(Collectors.groupingBy(product -> product.charAt(0)));
        groupByLetters.forEach((letter, productName) -> System.out.println(letter + "->" + productName));


    }
}
