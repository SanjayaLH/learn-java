package com.learn.streams;

import java.util.stream.IntStream;

public class StreamsExercise4 {
    public static void main(String[] args) {
        long startTimeS;
        long startTimeP;
        long endTimeS;
        long endTimeP;

        startTimeS = System.nanoTime();
        //Sequential sum
        int sequentialSum = IntStream.rangeClosed(1, 100).map(n -> n * n).sum();
        endTimeS = System.nanoTime();
        long totalSequentialTime = endTimeS - startTimeS;

        startTimeP = System.nanoTime();
        //Parallel sum
        int parallelSum = IntStream.rangeClosed(1, 100).map(n -> n * n)
                .parallel()
                .sum();
        endTimeP = System.nanoTime();
        long totalParallelTime = endTimeP - startTimeP;

        System.out.println("Sequential sum : " + sequentialSum);//Output-> 500500
        System.out.println("Time for Sequential sum : " + totalSequentialTime + "ns");//Output->
        System.out.println("Parallel sum : " + parallelSum);//Output-> 500500
        System.out.println("Time for Parallel sum : " + totalParallelTime + "ns");//Output->
    }
}
