package com.learn.threads.q1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TicketBookingDemoTwo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        TicketBookingSystem bookingSystem = new TicketBookingSystem(4); // available 4 tickets

        // Creating multiple user threads
        Thread mithi = new Thread(new UserTwo(bookingSystem, "Mithi", latch));
        Thread kass = new Thread(new UserTwo(bookingSystem, "Kassa", latch));
        Thread kalpa = new Thread(new UserTwo(bookingSystem, "Kalpa", latch));
        Thread issa= new Thread(new UserTwo(bookingSystem, "Issa", latch));
        Thread me = new Thread(new UserTwo(bookingSystem, "Sanj", latch));

        // Start booking simultaneously
        List<Thread> threads = Arrays.asList(mithi, kass, kalpa, issa, me);
        for (Thread thread : threads) {
            // start the treads but they would not invoke the ticket booking method : See User class run method
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println("All threads are ready. Starting now!");

        latch.countDown();
    }
}
