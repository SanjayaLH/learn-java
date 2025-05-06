package com.learn.threads.topic6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sample code for
 * 6. The wait() and notify() Methods
 */
public class ProcessingQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            System.out.println("producer waiting "+Thread.currentThread().getName());
            wait();
        }
        queue.add(value);
        System.out.println("producer waiting " +Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("consume waiting "+ Thread.currentThread().getName());
            wait();
        }
        int value = queue.poll();
        System.out.println("consume notifying "+Thread.currentThread().getName());
        notifyAll();
        return value;
    }

    public static void main(String[] args) {
        ProcessingQueue queue = new ProcessingQueue();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.produce(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            /*try {
                for (int i = 0; i < 10; i++) {
                    //System.out.println("Consumed: " + queue.consume());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }*/
        });

        producer.start();
        consumer.start();
    }
}
