package com.learn.threads.topic15.q15;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiTierServiceSimulatorRevised {

    static class ServiceTier {
        private final String tierName;
        private final ThreadGroup threadGroup;
        private final BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();
        private final ServiceTier nextTier;
        private final int maxThreads;
        private volatile boolean running = true;
        private int workerCount = 0;

        /**
         * @param tierName   logical name of this tier
         * @param nextTier   downstream tier (or null for last tier)
         * @param maxThreads absolute upper bound on workers for this tier
         */
        public ServiceTier(String tierName, ServiceTier nextTier, int maxThreads) {
            this.tierName = tierName;
            this.nextTier = nextTier;
            this.maxThreads = maxThreads;
            this.threadGroup = new ThreadGroup(tierName);
            createWorker();//Call the worker creating method inside the constructor
        }

        /**
         * 1) Submit a task into this tier's queue,
         * 2) then opportunistically scale if needed.
         */
        public void submitTask(String task) {
            taskQueue.add(task);
            adjustThreadsIfNeeded();
        }

        /**
         * Create exactly one more worker thread in this tier.
         */
        private void createWorker() {
            workerCount++;
            Thread worker = new Thread(threadGroup, () -> {
                while (running && !Thread.currentThread().isInterrupted()) {
                    try {
                        String t = taskQueue.take();
                        System.out.println("[" + tierName + "] processing: " + t
                                + " on " + Thread.currentThread().getName());
                        Thread.sleep(2_000);
                        if (nextTier != null) {
                            nextTier.submitTask(t);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, tierName + "-Worker-" + workerCount);
            worker.start();
        }

        /**
         * Whenever we enqueue a task; spins up enough workers
         * to keep pace, but never beyond maxThreads.
         */
        private synchronized void adjustThreadsIfNeeded() {
            int queueSize = taskQueue.size();
            int active = threadGroup.activeCount();
            // target one thread for every 2 waiting tasks, but at least 1
            int target = Math.min(maxThreads, Math.max(1, queueSize / 2));
            int toCreate = target - active;
            if (toCreate > 0) {
                System.out.println("[" + tierName + "] backlog=" + queueSize
                        + ", active=" + active + " → creating " + toCreate + " more workers");
                for (int i = 0; i < toCreate; i++) {
                    createWorker();
                }
            }
        }

        /**
         * Cleanly tear down: stop accepting, interrupt blocked workers
         */
        public void shutdown() {
            running = false;
            Thread[] threads = new Thread[threadGroup.activeCount()];
            threadGroup.enumerate(threads);
            for (Thread t : threads) {
                if (t != null) t.interrupt();
            }
            System.out.println("[" + tierName + "] shutdown");
        }
    }

    public static void main(String[] args) {
        // 1) Wire your pipeline: PRESENTATION → BUSINESS → DATA
        ServiceTier dataTier = new ServiceTier("DATA_TIER",    null,  10);
        ServiceTier busTier  = new ServiceTier("BUSINESS_TIER", dataTier, 10);
        ServiceTier pptTier  = new ServiceTier("PRESENTATION_TIER", busTier, 10);


        // 3) Simulator scheduler for random arrivals
        ScheduledExecutorService simulator = Executors.newSingleThreadScheduledExecutor(r ->
                new Thread(r, "Workload-Simulator")
        );

        AtomicInteger counter = new AtomicInteger(1);
        Runnable produce = new Runnable() {
            @Override
            public void run() {
                int i = counter.getAndIncrement();
                if (i <= 30) {
                    pptTier.submitTask("Request-" + i);
                    // schedule next run after [0,1000) ms
                    long delay = ThreadLocalRandom.current().nextInt(1_000);
                    simulator.schedule(this, delay, TimeUnit.MILLISECONDS);
                }
            }
        };

        simulator.schedule(produce, 0, TimeUnit.MILLISECONDS);

        // 4) Terminator: after 30s, shut down simulator + all tiers
        ScheduledExecutorService terminator = Executors.newSingleThreadScheduledExecutor(r ->
                new Thread(r, "Terminator")
        );
        terminator.schedule(() -> {
            System.out.println("\n=== Initiating shutdown ===");
            // stop generating any more tasks
            simulator.shutdownNow();
            // tear down each tier
            pptTier.shutdown();
            busTier.shutdown();
            dataTier.shutdown();
            // clean up this scheduler, too
            terminator.shutdown();
        }, 30, TimeUnit.SECONDS);
    }
}

