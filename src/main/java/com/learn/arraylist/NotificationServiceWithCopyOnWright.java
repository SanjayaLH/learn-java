package com.learn.arraylist;

import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationServiceWithCopyOnWright {

    // Thread-safe list of subscribers
    private CopyOnWriteArrayList<String> subscribers = new CopyOnWriteArrayList<>();

    // Method to add a subscriber
    public void addSubscriber(String user) {
        System.out.println(Thread.currentThread().getName() + " adding: " + user);
        subscribers.addIfAbsent(user); // Ensures no duplicates
    }

    // Method to remove a subscriber
    public void removeSubscriber(String user) {
        System.out.println(Thread.currentThread().getName() + " removing: " + user);
        subscribers.remove(user);
    }

    // Method to send notification to all subscribers
    public void sendNotification(String message) {
        System.out.println(Thread.currentThread().getName() + " sending notification: " + message);
        for (String user : subscribers) {
            System.out.println("Notifying: " + user + " - " + message);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NotificationServiceWithCopyOnWright service = new NotificationServiceWithCopyOnWright();

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
