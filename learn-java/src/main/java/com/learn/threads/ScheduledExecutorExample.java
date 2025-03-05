package com.learn.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Java program using newSingleThreadScheduledExecutor() to execute a task every 3 seconds.
 * Explanation:The task starts immediately (0 delay) and repeats every 3 seconds.
 */
public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable task = () -> System.out.println("Task executed at: " + System.currentTimeMillis());

        scheduler.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
    }
}
