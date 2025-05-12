package com.learn.threads.topic9.q9;

public class TaskSimulator {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = new Runnable() {
            private int counter = 0;
            @Override
            public void run() {
                while (counter < 1000000) {
                    counter++;
                }
                System.out.println(Thread.currentThread().getName() + " thread finish counting to " + counter);
            }
        };

        Thread backgroundTaskOne = new Thread(task, "backgroundTaskOne");
        Thread backgroundTaskTwo = new Thread(task, "backgroundTaskTwo");
        Thread backgroundTaskThree = new Thread(task, "backgroundTaskThree");
        Thread criticalTask = new Thread(task, "criticalTask");

        backgroundTaskOne.setPriority(Thread.MIN_PRIORITY);
        backgroundTaskTwo.setPriority(Thread.NORM_PRIORITY);
        backgroundTaskThree.setPriority(Thread.NORM_PRIORITY);
        criticalTask.setPriority(Thread.MAX_PRIORITY);

        backgroundTaskOne.start();
        backgroundTaskTwo.start();
        backgroundTaskThree.start();
        criticalTask.start();

    }
}
