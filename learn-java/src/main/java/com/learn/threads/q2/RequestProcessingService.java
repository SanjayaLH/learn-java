package com.learn.threads.q2;

public class RequestProcessingService {
    private volatile boolean exit = false;

    public void shutdown() {
        exit = true;
    }

    public static void main(String[] args) {

    }
}
