package com.learn.threads.q2;

import java.util.concurrent.*;

class RequestProcessorService {
    private final ExecutorService executorService;
    private final BlockingQueue<Runnable> taskQueue;
    private volatile boolean running = true;

    public RequestProcessorService(int numThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        executorService = Executors.newFixedThreadPool(numThreads);

        // Start worker threads to process tasks/requests
        for (int i = 0; i < numThreads; i++) {
            executorService.execute(this::processTasks);
        }
    }

    // Method to submit new tasks
    public void submitRequest(Runnable request) {
        if (running) {
            taskQueue.offer(request);
        } else {
            System.out.println("Service is shutting down. Cannot accept new requests.");
        }
    }

    // Worker method to process tasks from the queue
    private void processTasks() {
        try {
            while (running || !taskQueue.isEmpty()) {
                Runnable task = taskQueue.poll(1, TimeUnit.SECONDS);
                if (task != null) {
                    task.run();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Graceful shutdown method
    public void shutdown() {
        running = false;
        executorService.shutdown(); // Prevent new tasks from being submitted
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Now in Force shutdown");
                executorService.shutdownNow(); // Force shutdown if tasks take too long
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Service has been shut down.");
    }

    public static void main(String[] args) throws InterruptedException {
        RequestProcessorService service = new RequestProcessorService(3);

        // Submit example tasks
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            service.submitRequest(() -> {
                System.out.println("Processing task " + taskId + " on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(6000); // Simulate task processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Allow time for processing, then shutdown gracefully
        Thread.sleep(5000);
        System.out.println("Initiating shutdown...");
        service.shutdown();
    }
}
