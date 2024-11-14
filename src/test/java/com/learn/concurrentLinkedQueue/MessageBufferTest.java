package com.learn.concurrentLinkedQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MessageBufferTest {
    private MessageBuffer buffer;

    @BeforeEach
    public void setUp() {
        buffer = new MessageBuffer();
    }

    @Test
    void testAddAndProcessMessages() {
        assertEquals(true, buffer.isEmpty());
        buffer.addMsg("2024-11-12T10:15:30Z: Message from A1");
        assertEquals(false, buffer.isEmpty());
    }

    @Test
    void shouldProcessAllMsg() {
        buffer.addMsg("2024-11-12T10:15:30Z: Message from A1");
        buffer.addMsg("2024-11-12T10:15:31Z: Message from A2");

        String[] processedMessages = buffer.processAllMsg();

        // Ensure all messages are processed
        assertEquals(2, processedMessages.length);
    }

    @Test
    void shouldCheckAllProcessedMsgAreEmpty() {
        buffer.addMsg("2024-11-12T10:15:33Z: Message from B1");
        buffer.addMsg("2024-11-12T10:15:34Z: Message from B2");

        String[] processedMessages = buffer.processAllMsg();

        // Ensure all messages are cleared from Queue
        assertTrue(buffer.isEmpty());
    }

    @Test
    public void testConcurrentAccess() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Simulate multiple threads adding messages
        executor.submit(() -> buffer.addMsg("2024-11-12T10:15:30Z: Message from Thread 1"));
        executor.submit(() -> buffer.addMsg("2024-11-12T10:15:31Z: Message from Thread 2"));
        executor.submit(() -> buffer.addMsg("2024-11-12T10:15:32Z: Message from Thread 3"));

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