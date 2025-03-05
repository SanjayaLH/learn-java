package com.learn.threads;

/**
 * Sample code for
 * 10. Thread State
 */
public class ThreadStateExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Before start: " + thread.getState());
        thread.start();
        System.out.println("After start: " + thread.getState());
        Thread.sleep(100); // Adjust timing slightly to catch the thread while it sleeps
        System.out.println("During sleep: " + thread.getState());
        thread.join();
        System.out.println("After completion: " + thread.getState());
    }

}
