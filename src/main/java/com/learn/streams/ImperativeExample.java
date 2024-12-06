package com.learn.streams;

import java.util.Arrays;
import java.util.List;

public class ImperativeExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumOfEvenSquares = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                sumOfEvenSquares += num * num;
            }
        }
        System.out.println("Sum of Even Squares: " + sumOfEvenSquares);
    }
}
