package com.learn.questions.funcprog.q3;

import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        Function<Integer, Integer> addFunction = num -> num + 2;
        Function<Integer, Integer> multiplyFunction = num -> num * 3;
        Function<Integer, Integer> composeFunctions = addFunction.andThen(multiplyFunction);

        System.out.println(composeFunctions.apply(2));

    }
}
