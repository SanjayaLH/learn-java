package com.learn.threads.topic6.q6;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Restaurant {
    private final Queue<Integer> orderQ = new LinkedList<>();

    public void prepareAMeal(int mealId) {
        synchronized (orderQ) {
            int CAPACITY = 5;
            while (orderQ.size() == CAPACITY) {
                try {
                    orderQ.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
            orderQ.add(mealId);
            System.out.println("Meal " + mealId + " prepared by: " + Thread.currentThread().getName());
            orderQ.notifyAll();
        }
    }

    public void serve() {
        synchronized (orderQ) {
            while (orderQ.isEmpty()) {
                try {
                    orderQ.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
            int mealId = orderQ.poll();
            System.out.println("Meal " + mealId + " delivered by: " + Thread.currentThread().getName());
            orderQ.notifyAll();
        }
    }

    public static void main(String[] args) {
        int numChef = 5;
        int numWaiters = 1;
        Random random = new Random();
        Restaurant resturant = new Restaurant();

        for (int i = 0; i < numChef; i++) {

            new Thread(() -> {
                int mealId = random.nextInt();
                resturant.prepareAMeal(mealId);
                try {
                    Thread.sleep(1000);//Only for simulation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "Chef " + i).start();
        }

        for (int i = 0; i < numWaiters; i++) {

            new Thread(() -> {
                int mealsPerWaiter = numChef / numWaiters;

                for (int y = 0; y < mealsPerWaiter; y++) {
                    resturant.serve();
                    try {
                        Thread.sleep(1000);//Only for simulation
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }, "Waiter " + i).start();
        }

    }
}

