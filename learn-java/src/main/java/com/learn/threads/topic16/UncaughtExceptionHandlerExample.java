package com.learn.threads.topic16;

/**
 * Sample code for
 * 16. Uncaught Exceptions
 */
public class UncaughtExceptionHandlerExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional Exception");
        });

        thread.setUncaughtExceptionHandler((t, e) -> System.out.println(t + " throws exception: " + e));

        thread.start();
    }
}
