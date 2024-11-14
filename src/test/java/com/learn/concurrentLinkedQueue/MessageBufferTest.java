package com.learn.concurrentLinkedQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MessageBufferTest {
    private MessageBuffer messageBuffer;

    @BeforeEach
    public void setUp() {
         messageBuffer = new MessageBuffer();
    }
    @Test
    void testAddAndProcessMessages() {
        assertEquals(true,messageBuffer.isEmpty());
        messageBuffer.addMsg("2024-11-12T10:15:30Z: Message from A1");
        assertEquals(false,messageBuffer.isEmpty());
    }

    @Test
    void processAllMsg() {
    }

    @Test
    void isEmpty() {
    }
    @Test
    public void testConcurrentAccess() throws InterruptedException {
        MessageBuffer buffer = new MessageBuffer();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Simulate multiple threads adding messages
        executor.submit(() -> buffer.addMsg("2024-11-12T10:15:30Z: Message from Thread 1"));
        executor.submit(() -> buffer.addMsg("2024-11-12T10:15:31Z: Message from Thread 2"));
        executor.submit(() -> buffer.addMsg("2024-11-12T10:15:32Z: Message from Thread 3"));
        executor.submit(() -> buffer.addMsg("2024-11-12T10:15:32Z: Message from Thread 4"));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // Process messages after all threads have finished
        String[] processedMessages = buffer.processAllMsg();

        // Ensure all messages are processed
        assertEquals(3, processedMessages.length);

        // Validate order of the messages (depends on the order they were added)
        assertTrue(processedMessages[0].contains("Thread 1") ||
                processedMessages[1].contains("Thread 1") ||
                processedMessages[2].contains("Thread 1"));

        assertTrue(processedMessages[0].contains("Thread 2") ||
                processedMessages[1].contains("Thread 2") ||
                processedMessages[2].contains("Thread 2"));

        assertTrue(processedMessages[0].contains("Thread 3") ||
                processedMessages[1].contains("Thread 3") ||
                processedMessages[2].contains("Thread 3"));

        // Ensure buffer is empty after processing
        assertTrue(buffer.isEmpty());
    }
}