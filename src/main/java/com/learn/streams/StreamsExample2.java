package com.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsExample2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        //Filter numbers greater than 4
        List<Integer> filtered = numbers.stream().filter(num -> num > 4).collect(Collectors.toList());

        //Map numbers to their squares
        List<Integer> squared = numbers.stream().map(num -> num * num).collect(Collectors.toList());

        //Find the first number greater then 4
        Optional<Integer> firstGreaterThanFour = numbers.stream().filter(num -> num > 4).findFirst();

        System.out.println("Filtered : "+ filtered);//Output [5, 6, 7, 8]
        System.out.println("Squared : "+ squared);//Output [1, 4, 9, 16, 25, 36, 49, 64]
        System.out.println("First > 4 : "+ firstGreaterThanFour);//Output Optional[5]
    }
}
