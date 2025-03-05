package com.learn.threads;

import java.util.concurrent.ThreadFactory;

class CustomThreadFactory implements ThreadFactory {
    private int count = 1;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("Worker-" + count++);
        return thread;
    }
}
