package com.learn.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Imagine you're building a customer support system where each incoming customer query is assigned a task.
 * * These tasks are processed in the order they arrive, so customers are served on a first-come, first-served basis.
 * A Queue can be used to model this behavior effectively.
 *
 * * Solution Using Java's Queue Interface
 * * Choose the Queue Implementation: Since we need FIFO behavior,
 * * LinkedList is a good choice as it implements Queue and provides add() and poll()
 * * operations with constant-time complexity for insertion and removal at the head and tail.
 */
public class CustomerSupportSystem {
    private final Queue<String> taskQueue;

    public CustomerSupportSystem() {
        this.taskQueue = new LinkedList<>();
    }

    public void addTask(String task) {
        taskQueue.add(task);
    }

    public void processNextTask() {
        String task = taskQueue.poll();

        if (task == null) {
            System.out.println("No task available");
        } else {
            System.out.println("Processing:"+task);
        }
    }

    public static void main(String[] args) {
        CustomerSupportSystem supportSystem = new CustomerSupportSystem();

        supportSystem.addTask("Customer 1: Password Reset");
        supportSystem.addTask("Customer 2: Billing Issue");
        supportSystem.addTask("Customer 3: Technical Support");

        supportSystem.processNextTask();
        supportSystem.processNextTask();
        supportSystem.processNextTask();
        supportSystem.processNextTask();
    }
}
