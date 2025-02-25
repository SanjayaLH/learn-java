package com.learn.threads.q1;

class User implements Runnable {
    private final TicketBookingSystem bookingSystem;
    private final String userName;

    public User(TicketBookingSystem bookingSystem, String userName) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
    }

    @Override
    public void run() {
        bookingSystem.bookTicket(userName);
    }
}
