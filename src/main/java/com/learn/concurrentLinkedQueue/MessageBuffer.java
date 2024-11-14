package com.learn.concurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * You are developing a real-time chat application where multiple users can send messages to a shared chat room.
 * Messages arrive from various users concurrently and need to be processed in the order they were received.
 * Once processed, the messages are dispatched to all connected clients.
 *
 * To handle this, implement a MessageBuffer class that uses a ConcurrentLinkedQueue to buffer the incoming messages.
 * The class must support the following functionalities:
 *
 * Add a Message: Add a message to the buffer. Messages are strings with a timestamp prefix, e.g., "2024-11-12T10:15:30Z: Hello World!".
 * Retrieve and Process Messages: Retrieve and remove all messages from the buffer for processing (in the order they were received).
 * Check if Buffer is Empty: Determine if there are any messages left to process.
 * Your implementation must support concurrent writes (from multiple threads adding messages) and a single-threaded processor that retrieves and processes the messages.
 *
 * Requirements:
 * Thread-Safety: Ensure that the buffer handles concurrent access correctly without losing or reordering messages.
 * Unit Tests: Write unit tests to validate the behavior of the MessageBuffer class under concurrent scenarios.
 * Example:
 * Given:
 *
 * Threads A, B, and C add the following messages concurrently:
 * Thread A: "2024-11-12T10:15:30Z: Message from A1", "2024-11-12T10:15:35Z: Message from A2"
 * Thread B: "2024-11-12T10:15:32Z: Message from B1"
 * Thread C: "2024-11-12T10:15:33Z: Message from C1"
 * A single-threaded processor retrieves messages for dispatch.
 * Expected: The messages are retrieved and processed in the order they were added:
 *
 * "2024-11-12T10:15:30Z: Message from A1"
 * "2024-11-12T10:15:32Z: Message from B1"
 * "2024-11-12T10:15:33Z: Message from C1"
 * "2024-11-12T10:15:35Z: Message from A2"
 */
public class MessageBuffer {
    private ConcurrentLinkedQueue<String> msgQueue;

    public MessageBuffer() {
        msgQueue = new ConcurrentLinkedQueue<>();
    }

    public void addMsg(String msg) {
        msgQueue.add(msg);
    }

    public String[] processAllMsg() {
        String[] msgs = msgQueue.toArray(new String[0]);
        msgQueue.clear();
        return msgs;
    }

    public boolean isEmpty() {
        return msgQueue.isEmpty();
    }
}
