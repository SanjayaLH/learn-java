package com.learn.threads;

public class SharedData {
    private volatile int sharedCounter;

    public void increment() {
        synchronized (this) {
            sharedCounter++;
        }
    }

    public int getSharedCounter() {
        return sharedCounter;
    }

    public static void main(String[] args) throws InterruptedException {
        SharedData data = new SharedData();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                data.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                data.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Shared Counter: " + data.getSharedCounter());
    }

}
