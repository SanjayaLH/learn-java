package com.learn.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java program that uses newFixedThreadPool with a custom ThreadFactory that names each thread.
 * Explanation: The ThreadFactory assigns custom names (Worker-1, Worker-2, etc.), making debugging easier.
 */
public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3, new CustomThreadFactory());

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " processing task " + taskId);
            });
        }
        executor.shutdown();
    }
}
