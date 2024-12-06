package com.learn.streams;

import java.util.stream.IntStream;

public class StreamsExample4 {
    public static void main(String[] args) {
        //Sequential sum
        int sequentialSum = IntStream.rangeClosed(1, 1000).sum();

        //Parallel sum
        int parallelSum = IntStream.rangeClosed(1, 1000)
                .parallel()
                .sum();

        System.out.println("Sequential sum : " + sequentialSum);//Output-> 500500
        System.out.println("Parallel sum : " + parallelSum);//Output-> 500500
    }
}
