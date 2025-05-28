package com.learn.threads.topic17.q17;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ImageProcessorSimulator {
    private int rows;
    private int columns;
    private BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();

    public ImageProcessorSimulator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void uploadImage(String imageName) {
        System.out.println("Image " + imageName + " uploaded successfully...");
    }

    public int calTaskAmount(int numOfRows, int numOfCols) {
        return numOfRows * numOfCols;// calculate # image chunks
    }

    public void createTask(String imageName, int imageChunks) {
        for (int i = 1; i <= imageChunks; i++) {
            String imageId = String.valueOf(i);
            String imageTask = imageName + imageId;
            taskQueue.add(imageTask);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int numOfThreads = 2;
        int imageChunks;
        ImageProcessorSimulator simulator = new ImageProcessorSimulator(2, 2);
        simulator.uploadImage("Image01");
        imageChunks = simulator.calTaskAmount(simulator.rows, simulator.columns);

        simulator.createTask("Image01", imageChunks);
        System.out.println("Queue size: " + simulator.taskQueue.size());

        Thread[] threads = new Thread[numOfThreads];
        long startTime = System.currentTimeMillis(); // Start measuring before threads start, nanoTime() more accurate

        for (int i = 0; i < numOfThreads; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    try {
                        /*
                        Return null when Q isEmpty,avoid blocking to allow exit. take() waits if Q empty
                         */
                        String task = simulator.taskQueue.poll();
                        if (task == null) break;

                        System.out.println("[" + Thread.currentThread().getName() + "] processing: " + task);
                        Thread.sleep(100); // Simulate processing
                        System.out.println(task + " processed");

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, "ProcessorThread-" + i);
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join(); // Wait for all threads to finish
        }

        long endTime = System.currentTimeMillis(); // Stop timer after all threads complete

        System.out.println("Thread execution time: " + (endTime - startTime) + " ms");
    }

}
