package com.learn.threads.q1;

/**
 * Problem: Design a multi-threaded ticket booking system
 * where multiple users can book tickets simultaneously without any data inconsistency.
 */
public class TicketBookingSystem {

    private int availableTickets;

    public TicketBookingSystem(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    public synchronized boolean bookTicket(String user) {
        if (availableTickets > 0) {
            System.out.println(user + " booked 1 ticket. Remaining: " + (availableTickets - 1));
            availableTickets--;
            return true;
        } else {
            System.out.println(user + " failed to book. No tickets left.");
            return false;
        }
    }
}
