package com.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of integers, use streams to:
 * Filter even numbers.
 * Collect them into a list.
 * Print the result.
 */
public class StreamsExercise1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 5, 1, 3, 4, 6);

        //Using Streams to filter and collect even numbers to a list
        List<Integer> evenNumbers = integers.stream()
                .filter(num -> num % 2 == 0)//Intermediate operation
                .collect(Collectors.toList());//Terminal operation

        System.out.println(evenNumbers);//Output [2, 4, 6]
    }
}
