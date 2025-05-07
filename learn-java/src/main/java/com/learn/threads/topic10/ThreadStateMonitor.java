package com.learn.threads.topic10;

public class ThreadStateMonitor extends Thread {

    public ThreadStateMonitor(String name) {
        super(name);
    }

    public void count() {
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            count++;
        }
        System.out.println("Thread counting to: " + count );
    }

    public void eat() throws InterruptedException {
        System.out.println("Thread is eating " );
        Thread.sleep(1000);

    }

    public void read() throws InterruptedException {
        System.out.println("Thread is reading a book " );
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " >>>," + Thread.currentThread().getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStateMonitor tCount = new ThreadStateMonitor("Counting-thread ");
        System.out.println(tCount.getName()+ " "+tCount.getState());
        tCount.start();
        System.out.println(tCount.getName()+ " "+tCount.getState());
        tCount.count();
        System.out.println(tCount.getName()+ " "+tCount.getState());
        tCount.join();
        System.out.println(tCount.getName()+ " "+tCount.getState());

        ThreadStateMonitor tEat = new ThreadStateMonitor("Eating-thread ");
        System.out.println(tEat.getName()+ " "+tEat.getState());
        tEat.start();
        System.out.println(tEat.getName()+ " "+tEat.getState());
        tEat.eat();
        System.out.println(tEat.getName()+ " "+tEat.getState());
        tEat.join();
        System.out.println(tEat.getName()+ " "+tEat.getState());

        ThreadStateMonitor tRead = new ThreadStateMonitor("Reading-thread ");
        System.out.println(tRead.getName()+ " "+tRead.getState());
        tRead.start();
        System.out.println(tRead.getName()+ " "+tRead.getState());
        tRead.read();
        System.out.println(tRead.getName()+ " "+tRead.getState());
        tRead.join();
        System.out.println(tRead.getName()+ " "+tRead.getState());
    }

}
