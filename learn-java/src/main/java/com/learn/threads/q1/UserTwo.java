package com.learn.threads.q1;

import java.util.concurrent.CountDownLatch;

class UserTwo implements Runnable {
    private final TicketBookingSystem bookingSystem;
    private final String userName;
    private CountDownLatch latch;

    public UserTwo(TicketBookingSystem bookingSystem,
                String userName, CountDownLatch latch) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // bookTicket method does not get invoked from the
            // thread until the latch await release this thread.
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("Current thread is interrupted while waiting");
        }
        bookingSystem.bookTicket(userName);
    }
}

