package com.learn.threads.topic17;

/**
 * 17. Thread Performance
 */
public class ThreadPerformanceExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                double a = Math.sin(i) * Math.cos(i);
            }
        });

        System.out.println("Thread state-1: " + thread.getState());
        thread.start();
        System.out.println("Thread state-2: " + thread.getState());
        try {
            System.out.println("Thread state-3: " + thread.getState());
            thread.join();
            System.out.println("Thread state-4: " + thread.getState());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Thread execution time: " + (endTime - startTime) + " ms");
        System.out.println("Thread state-5: " + thread.getState());
    }

}
