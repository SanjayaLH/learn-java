package com.learn.streams;

import java.util.HashMap;
import java.util.Map;

public class MapIdiomaticExample {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Merge idiom: count occurrences of words
        wordCount.merge("apple", 1,Integer::sum);//Adds "apple" -> 1
        wordCount.merge("banana", 1,Integer::sum);//Adds "banana" -> 1
        wordCount.merge("apple", 1,Integer::sum);//Updates "apple" -> 2

        System.out.println("Word counts : "+wordCount);

        // Compute idiom: calculate square if present, else insert default
        wordCount.computeIfPresent("banana", (k,v) -> v * v); //Squares "banana"
        wordCount.computeIfAbsent("cherry", k -> 42); //Adds "cherry" -> 42

        System.out.println("Update word counts : "+wordCount);
    }
}
