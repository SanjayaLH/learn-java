package com.learn.threads;

public class MultiJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("Thread 1 completed.");
        });

        Thread t2 = new Thread(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println("Thread 2 completed.");
        });

        t1.start();
        t2.start();

        try {
            t1.join();//Main thread waits only for t1, not t2.
            System.out.println("Main thread waited for t1.");
            t2.join();//Main thread waits for t2 after t1 completes.
            System.out.println("Main thread waited for t2.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread resumes after all joins.");
    }
}
