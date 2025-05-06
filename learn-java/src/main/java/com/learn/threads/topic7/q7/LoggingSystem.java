package com.learn.threads.topic7.q7;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LoggingSystem {
    private final int CAPACITY = 5;
    private final BlockingQueue<String> loggingQueue = new ArrayBlockingQueue<>(CAPACITY);

    public void produceMsg(String msg) throws InterruptedException {
        synchronized (loggingQueue) {
            while (loggingQueue.size() == CAPACITY) {
                loggingQueue.wait();

            }
            System.out.println(Thread.currentThread().getName() + " " + ">>> " + msg + " add to the queue");
            loggingQueue.put(msg);
            loggingQueue.notifyAll();
            System.out.println("Queue size :" + loggingQueue.size());

        }
    }

    public String writeMsg() throws InterruptedException {
        return loggingQueue.take();
    }

    public static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        int numLogProducer = 5;
        int numLogConsumer = 2;

        Random random = new Random();
        LoggingSystem loggingSystem = new LoggingSystem();

        for (int i = 0; i < numLogProducer; i++) {

            new Thread(() -> {
                String msgId = String.valueOf(random.nextInt());
                String tt = getCurrentTimestamp();
                try {
                    loggingSystem.produceMsg(msgId + " ," + tt + " msg");
                    System.out.println("Queue size :" + loggingSystem.loggingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "LogProducer " + i).start();
        }
        for (int i = 0; i < numLogConsumer; i++) {

            new Thread(() -> {
                int msgPerConsumer = numLogProducer / numLogConsumer;

                for (int y = 0; y <= msgPerConsumer; y++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " " + "<<< " + loggingSystem.writeMsg() + " read from queue");
                        System.out.println("Queue size :" + loggingSystem.loggingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }, "LogConsumer " + i).start();
        }
    }
}

