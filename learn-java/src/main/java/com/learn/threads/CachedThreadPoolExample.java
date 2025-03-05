package com.learn.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java program using newCachedThreadPool() to process dynamic tasks efficiently.
 * Explanation:newCachedThreadPool() dynamically creates threads as needed and reuses idle threads for new tasks.
 */
public class CachedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " processing task " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Task interrupted");
                }
            });
        }
        executor.shutdown();
    }
}
