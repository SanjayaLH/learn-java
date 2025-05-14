package com.learn.threads.topic16.q16;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class IncomingDataFeedProcessorSimulator {

    static class DatafeedProcessor {
        private final BlockingQueue<String> dataFeedQueue = new LinkedBlockingQueue<>();
        private volatile boolean running = true;
        private int processorCount = 0;

        /**
         * Submit a data feeds into this dataFeedQueue.
         */
        public void loadDataFeed(String datafeed) {
            dataFeedQueue.add(datafeed);
        }

        /**
         * Create a data feed processor thread
         */
        public void createDatafeedProcessor() {
            processorCount++;
            String threadName = "Processor-Thread-" + processorCount;
            startProcessorThread(threadName, 3); // 3 retries
        }

        /**
         * Handle the uncaught exception in processor thread and
         * Restart the thread if crashed.
         */
        private void startProcessorThread(String threadName, int retriesLeft) {
            ThreadGroup group = new ThreadGroup("Processor-group");

            Thread processor = new Thread(group, () -> {
                while (running) {
                    try {
                        String dataFeed = dataFeedQueue.take();
                        if (dataFeed.contains("ERROR")) {//Simulated failure in the thread.
                            System.out.println("Trying to process: " + dataFeed + " by " + Thread.currentThread().getName());
                            throw new RuntimeException("Intentional Exception" + " Simulated failure in " + Thread.currentThread().getName());
                        } else {
                            System.out.println("Processing: " + dataFeed + " by " + Thread.currentThread().getName());
                            Thread.sleep(2000); // Stay 2S to simulate
                        }

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

            }, threadName);

            //Restarting the damaged thread
            processor.setUncaughtExceptionHandler((t, e) -> {
                System.out.println(t.getName() + " crashed with: " + e.getMessage());
                if (retriesLeft > 0) {
                    System.out.println("Restarting " + t.getName() + " (" + retriesLeft + " retries left)");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    startProcessorThread(threadName, retriesLeft - 1); // Restart with fewer retries
                } else {
                    System.out.println("Max retries reached. Not restarting " + t.getName());
                }
            });
            processor.start();
        }
    }

    public static void main(String[] args) {
        int numProcessors = 2;
        DatafeedProcessor datafeedProcessor = new DatafeedProcessor();

        // Here simulate generate data feed
        new Thread(() -> {
            Random r = new Random();
            int min = 1, max = 10;
            int randomNum = r.nextInt(max - min + 1) + min;
            int counter = 1;
            while (counter <= 10) {
                if (counter == randomNum) {
                    String datafeed = "DataFeed-ERROR-" + counter++;//Add ERROR string to the data feed
                    datafeedProcessor.loadDataFeed(datafeed);

                } else {
                    String datafeed = "DataFeed-" + counter++;
                    datafeedProcessor.loadDataFeed(datafeed);
                }
            }
            System.out.println("Data Feed Queue size : " + datafeedProcessor.dataFeedQueue.size());
        }).start();

        for (int i = 0; i < numProcessors; i++) {
            datafeedProcessor.createDatafeedProcessor();
        }
    }
}
