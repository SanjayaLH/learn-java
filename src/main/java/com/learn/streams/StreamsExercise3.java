package com.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of integers,
 * group them by odd/even and calculate the sum for each group.
 */
public class StreamsExercise3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> odds = numbers.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        int sumOfOdds = numbers.stream().filter(num -> num % 2 != 0).mapToInt(Integer::intValue).sum();

        List<Integer> evens = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        int sumOfEvens = numbers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();

        System.out.println("Odds : "+ odds);
        System.out.println("Sum Of Odds : "+ sumOfOdds);
        System.out.println("Evens : "+ evens);
        System.out.println("Sum of Evens : "+ sumOfEvens);







    }
}
