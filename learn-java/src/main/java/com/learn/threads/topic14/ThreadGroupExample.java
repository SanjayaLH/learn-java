package com.learn.threads.topic14;
/**
 * Sample code for
 * 14. Thread Groups
 */
public class ThreadGroupExample {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Group");

        Thread t1 = new Thread(group, () -> {
            System.out.println("Thread 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(group, () -> {
            System.out.println("Thread 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
        System.out.println("Number of active threads in group: " + group.activeCount());
    }
}

