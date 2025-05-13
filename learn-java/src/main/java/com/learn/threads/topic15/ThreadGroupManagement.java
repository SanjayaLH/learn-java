package com.learn.threads.topic15;

/**
 * Sample code for
 * 15. Working with ThreadGroups
 */
public class ThreadGroupManagement {

    public static void main(String[] args) {
        ThreadGroup parentGroup = new ThreadGroup("ParentGroup");
        ThreadGroup childGroup = new ThreadGroup(parentGroup, "ChildGroup");

        Thread parentThread = new Thread(parentGroup, () -> {
            System.out.println("Parent group thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread childThread = new Thread(childGroup, () -> {
            System.out.println("Child group thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        parentThread.start();
        childThread.start();

        System.out.println("Active threads in parent group: " + parentGroup.activeCount());
        System.out.println("Active threads in child group: " + childGroup.activeCount());
    }
}
