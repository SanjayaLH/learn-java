package com.learn.threads.topic9;

/**
 * Sample code for
 * 9. Scheduling and Priority
 */
public class PriorityExample {

    public static void main(String[] args) {
        Thread minPriority = new Thread(() -> {
            System.out.println("Thread with min priority running");
        });
        Thread maxPriority = new Thread(() -> {
            System.out.println("Thread with max priority running");
        });

        minPriority.setPriority(Thread.MIN_PRIORITY);
        maxPriority.setPriority(Thread.MAX_PRIORITY);

        maxPriority.start();
        minPriority.start();
    }

}
