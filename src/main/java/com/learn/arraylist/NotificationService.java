package com.learn.arraylist;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    // Non-thread-safe list of subscribers
    List<String> subscribers = new ArrayList<>();

    // Method to add a subscriber
    public synchronized void addSubscriber(String user) {
        System.out.println(Thread.currentThread().getName() + " adding: " + user);
        subscribers.add(user);
    }

    // Method to remove a subscriber
    public synchronized void removeSubscriber(String user) {
        System.out.println(Thread.currentThread().getName() + " removing: " + user);
        subscribers.remove(user);
    }

    // Method to send notification to all subscribers
    public void sendNotification(String message) {
        System.out.println(Thread.currentThread().getName() + " sending notification: " + message);
        for (String user : subscribers) {  // This will cause ConcurrentModificationException
            System.out.println("Notifying: " + user + " - " + message);
            try {
                Thread.sleep(10);  // Simulate notification delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NotificationService service = new NotificationService();

        // Thread to add subscribers
        Thread adderThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                service.addSubscriber("User" + i);
                try {
                    Thread.sleep(50); // Simulate time taken for adding
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "AdderThread");

        // Thread to remove subscribers
        Thread removerThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                service.removeSubscriber("User" + i);
                try {
                    Thread.sleep(100); // Simulate time taken for removing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "RemoverThread");

        // Thread to send notifications
        Thread notifierThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                service.sendNotification("Notification " + i);
                try {
                    Thread.sleep(75); // Simulate time taken to send notifications
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "NotifierThread");

        // Start all threads
        adderThread.start();
        removerThread.start();
        notifierThread.start();

        // Wait for all threads to complete
        adderThread.join();
        removerThread.join();
        notifierThread.join();

        System.out.println("Final subscribers list: " + service.subscribers);
    }
}
