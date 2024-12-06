package com.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Aack", "Jill");

        //Using Streams to filter and collect names that start with 'J'
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("J"))//Intermediate operation
                .collect(Collectors.toList());//Terminal operation

        System.out.println(filteredNames);//Output [John, Jane, Jill]
    }
}
