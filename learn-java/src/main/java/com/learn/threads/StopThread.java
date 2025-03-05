package com.learn.threads;

/**
 * Sample code for
 * 2. Controlling Threads: Death of a Thread
 */
public class StopThread implements Runnable {
    /*
    volatile-makes variable's visibility among all the treads if have multiple
     */
    private volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit) {
            System.out.println("Server is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
                exit = true;
            }
        }
        System.out.println("Server is stopping...");
    }

    public void stop() {
        exit = true;
    }

    public static void main(String[] args) throws InterruptedException {
        StopThread task = new StopThread();
        Thread thread = new Thread(task);

        thread.start();
        //can use thread.interrupt() here to execute catch section
        Thread.sleep(5000);
        task.stop();
    }
}

