package com.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, perform the following using streams:
 * Filter strings containing more than 4 characters.
 * Convert them to uppercase.
 * Find any string that ends with "E".
 */
public class StreamsExercise2 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Johny", "Jane", "Jacky", "Jill");

        //Filter strings containing more than 4 characters.
        List<String> filter = names.stream().filter(name -> name.length() > 4).collect(Collectors.toList());

        //Convert them to uppercase.
        List<String> uppercase = names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());

        //Find any string that ends with "E"
        List<String> nameEndsWithE = names.stream().map(name -> name.toUpperCase())
                .filter(name -> name.endsWith("E"))
                .collect(Collectors.toList());


        System.out.println(filter);// Output [Johny, Jacky]
        System.out.println(uppercase);// Output [JOHNY, JANE, JACKY, JILL]
        System.out.println(nameEndsWithE);// Output [JANE]

    }


}
