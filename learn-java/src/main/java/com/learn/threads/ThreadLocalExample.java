package com.learn.threads;

/**
 * Sample code for
 * 8. ThreadLocal Objects
 */
public class ThreadLocalExample {

    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        Runnable task = () -> {
            int id = threadId.get();
            threadId.set(id + 1);
            System.out.println("Thread ID: " + threadId.get());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }

}
