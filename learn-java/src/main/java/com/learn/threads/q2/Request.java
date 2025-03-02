package com.learn.threads.q2;

public class Request implements Runnable {

    private final int requestId;

    public Request(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public void run() {
        System.out.println("Request is processing..." + requestId);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Request " + requestId + " was interrupted.");
        }
        System.out.println("Completed request: " + requestId);
    }
}
