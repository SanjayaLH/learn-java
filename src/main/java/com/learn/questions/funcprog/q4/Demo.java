package com.learn.questions.funcprog.q4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<String> productNames =Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");

        List<String> startFromA = productNames.stream().filter(s->s.startsWith("a")).collect(Collectors.toList());
        List<String> startFromb = productNames.stream().filter(s->s.startsWith("b")).collect(Collectors.toList());
        System.out.println("a->"+startFromA);
        System.out.println("a->"+startFromb);

    }
}
