package com.learn.threads;

/**
 * 1. The Thread Class and the Runnable Interface
 */
public class ThreadExample implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running.");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadExample());
        thread.start();
    }
}
