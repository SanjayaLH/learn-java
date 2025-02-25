package com.learn.threads;

public class LoginQueue {
    private int slotsAvailable;

    public LoginQueue(int maxSlots) {
        this.slotsAvailable = maxSlots;
    }

    public synchronized boolean tryLogin() {
        if (slotsAvailable > 0) {
            slotsAvailable--;
            return true;
        }
        return false;
    }

    public synchronized void logout() {
        slotsAvailable++;
    }

    public static void main(String[] args) {
        LoginQueue queue = new LoginQueue(1);

        Runnable loginAttempt = () -> {
            System.out.println("Attempt to login: " + queue.tryLogin());
        };

        new Thread(loginAttempt).start();
        new Thread(loginAttempt).start();
    }
}
