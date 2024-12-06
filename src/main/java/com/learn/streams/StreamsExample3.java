package com.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Streams", "Lambda", "Code", "Java");

        //Group words by their length
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        //Count occurrences of each word
        Map<String, Long> wordCounts = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println("Group by length : " + groupedByLength);//Output-> {4=[Java, Code, Java], 6=[Lambda], 7=[Streams]}
        System.out.println("Word counts : " + wordCounts);//Output->  {Java=2, Code=1, Lambda=1, Streams=1}

    }
}
