package com.learn.threads.topic15.q15;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiTierServiceSimulator {
    static class ServiceTier {
        private final String tierName;
        private final ThreadGroup treadGroup;
        private final BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();
        private volatile boolean running = true;
        private int workerCount = 0;


        public ServiceTier(String tierName) {
            this.tierName = tierName;
            this.treadGroup = new ThreadGroup(tierName);
        }

        public void submitTask(String task) {
            taskQueue.add(task);
        }

        public void createWorker() {
            workerCount++;
            Thread worker = new Thread(treadGroup, () -> {
                while (running && !Thread.currentThread().isInterrupted()) {
                    try {
                        String task = taskQueue.take();
                        System.out.println("[" + tierName + "] processing: " + task + " by " + Thread.currentThread().getName());
                        Thread.sleep(2000); // Stay 2S after create the worker to simulate work

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

            }, tierName + "-WorkerThread " + workerCount);
            worker.start();
        }

        public void startWork(int initialThreads) {
            for (int i = 0; i < initialThreads; i++) {
                createWorker();
            }
            // Monitor workload and adjust thread count every 5 seconds
            new Thread(() -> {
                while (running) {
                    try {
                        Thread.sleep(5000);
                        System.out.println("Inside startWork() thread --------> <while> ");
                        adjustThreads();
                    } catch (InterruptedException ignored) {
                    }
                }
            }, tierName + "-Scaler").start();
        }

        private void adjustThreads() {
            int queueSize = taskQueue.size();
            int active = treadGroup.activeCount();
            int idealThreads = Math.min(10, Math.max(1, queueSize / 2)); // Scale 1-10 based on workload and increase the threads count

            System.out.println("[" + tierName + "] queueSize=" + queueSize + ", activeThreads=" + active + ", target=" + idealThreads);

            int difference = idealThreads - active;
            if (difference > 0) {
                for (int i = 0; i < difference; i++) createWorker();
            }
        }

        public void shutdown() {
            running = false;
            // Interrupt workers that might be blocked on take()
            Thread[] threads = new Thread[treadGroup.activeCount()];
            treadGroup.enumerate(threads);
            for (Thread t : threads) {
                if (t != null) t.interrupt();
            }
            System.out.println("[" + tierName + "] Shutdown initiated.");
        }

    }

    public static void main(String[] args) {
        ServiceTier pptTier = new ServiceTier("PRESENTATION_TIER");
        ServiceTier busTier = new ServiceTier("BUSINESS_TIER");
        ServiceTier dataTier = new ServiceTier("DATA_TIER");

        pptTier.startWork(1);
        busTier.startWork(1);
        dataTier.startWork(1);

        // Here simulate workload randomly
        new Thread(() -> {
            Random random = new Random();
            int counter = 1;
            while (counter <= 30) {
                String task = "Request-" + counter++;
                pptTier.submitTask(task);
                busTier.submitTask(task);
                dataTier.submitTask(task);
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException ignored) {
                }
            }
        }).start();
        // Shutdown all tiers after 30 seconds
        new Thread(() -> {
            try {
                Thread.sleep(30000); // wait 30 seconds before shutdown
                System.out.println("\nInitiating shutdown...");
                pptTier.shutdown();
                busTier.shutdown();
                dataTier.shutdown();
            } catch (InterruptedException ignored) {
            }
        }).start();
    }

}

