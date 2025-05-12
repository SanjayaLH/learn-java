package com.learn.threads.topic9.q9;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class PrioritySchedulingSimulation {

    static class BusyTask implements Runnable {
        private volatile boolean running = true;
        private long counter = 0;
        private final String name;
        private final ThreadMXBean threadBean;

        public BusyTask(String name, ThreadMXBean threadBean) {
            this.name = name;
            this.threadBean = threadBean;
        }

        @Override
        public void run() {
            long tid = Thread.currentThread().getId();
            long startCpu = threadBean.getThreadCpuTime(tid);

            while (running) {
                counter++;
                if ((counter & 0xFFFF) == 0) {
                    Thread.yield();
                }
            }

            long endCpu = threadBean.getThreadCpuTime(tid);
            long cpuTimeMs = (endCpu - startCpu) / 1_000_000;

            System.out.printf(
                    "%s (priority=%d) did %,d iterations and used %d ms of CPU time%n",
                    name,
                    Thread.currentThread().getPriority(),
                    counter,
                    cpuTimeMs
            );
        }

        public void stop() {
            running = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int NUM_BACKGROUND = 3;
        final int RUN_SECONDS    = 10;


        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        if (!threadBean.isThreadCpuTimeSupported()) {
            System.err.println("Thread CPU time measurement not supported.");
            return;
        }
        threadBean.setThreadCpuTimeEnabled(true);


        BusyTask criticalTask = new BusyTask("CriticalTask", threadBean);
        Thread criticalThread = new Thread(criticalTask, "Critical");
        criticalThread.setPriority(Thread.MAX_PRIORITY);


        BusyTask[] bgTasks = new BusyTask[NUM_BACKGROUND];
        Thread[]   bgThreads = new Thread[NUM_BACKGROUND];
        for (int i = 0; i < NUM_BACKGROUND; i++) {
            bgTasks[i]   = new BusyTask("Background-" + (i+1), threadBean);
            bgThreads[i] = new Thread(bgTasks[i], "Background-" + (i+1));
            bgThreads[i].setPriority(Thread.MIN_PRIORITY);
        }


        criticalThread.start();
        for (Thread t : bgThreads) {
            t.start();
        }


        Thread.sleep(RUN_SECONDS * 1_000L);


        criticalTask.stop();
        for (BusyTask task : bgTasks) {
            task.stop();
        }


        criticalThread.join();
        for (Thread t : bgThreads) {
            t.join();
        }
    }
}
