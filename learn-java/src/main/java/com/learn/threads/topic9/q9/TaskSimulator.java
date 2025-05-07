package com.learn.threads.topic9.q9;

public class TaskSimulator {
    private int counter = 0;

    public void print() {
        while (counter < 100) {
            counter++;
        }
        System.out.println(Thread.currentThread().getName() + " thread finish counting to " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        TaskSimulator taskSimulator = new TaskSimulator();

        Thread backgroundTaskOne = new Thread(taskSimulator::print, "backgroundTaskOne");
        Thread backgroundTaskTwo = new Thread(taskSimulator::print, "backgroundTaskTwo");
        Thread backgroundTaskThree = new Thread(taskSimulator::print, "backgroundTaskThree");
        Thread criticalTask = new Thread(taskSimulator::print, "criticalTask");

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
