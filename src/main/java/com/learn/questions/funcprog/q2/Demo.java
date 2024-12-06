package com.learn.questions.funcprog.q2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> out = numbers.stream()
                .filter(num -> num % 2 != 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(out);

    }

}
