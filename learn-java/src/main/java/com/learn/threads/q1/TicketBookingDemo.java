package com.learn.threads.q1;

public class TicketBookingDemo {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(4); // available 4 tickets

        // Creating multiple user threads
        Thread mithi = new Thread(new User(bookingSystem, "Mithi"));
        Thread kass = new Thread(new User(bookingSystem, "Kassa"));
        Thread kalpa = new Thread(new User(bookingSystem, "Kalpa"));
        Thread issa= new Thread(new User(bookingSystem, "Issa"));
        Thread me = new Thread(new User(bookingSystem, "Sanj"));

        // Start booking simultaneously
        mithi.start();
        kass.start();
        kalpa.start();
        issa.start();
        me.start();
    }
}
