package com.learn.set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetDemoTest {

    private SetDemo setDemo;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        setDemo = new SetDemo();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldHaveInsertedValuesWODuplicatesDemoHashSet() {
        setDemo.demoHashSet();

        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("[aa, bb, cc]"));
    }

    @Test
    void shouldPrintUnicUsers() {
        setDemo.printUnicUsers();

        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("List of users:[user1, user2, user3, user4]"));
    }

    @Test
    void shouldPrintUsersInOrderToLogIn() {
        setDemo.printUsersInOrderToLogIn();

        String output = outputStreamCaptor.toString().trim();
        assertEquals("List of users:[user1, user3, user2, user4]", output);
    }

    @Test
    void shouldPrintUsersInSortedOrder() {
        setDemo.printUsersInSortedOrder();

        String output = outputStreamCaptor.toString().trim();
        assertEquals("List of users:[user1, user2, user3, user4]", output);
    }
}