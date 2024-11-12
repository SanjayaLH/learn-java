package com.learn.arraydeque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrowserHistoryTest {
    private BrowserHistory history;

    @BeforeEach
    void setUp() {
        history = new BrowserHistory();
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenVisitInvalidNullPage() {
        assertThrows(IllegalArgumentException.class, () -> history.visit(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenVisitInvalidEmptyPage() {
        assertThrows(IllegalArgumentException.class, () -> history.visit(""));
    }

    @Test
    void goBackShouldGivePreviousPage() {
        history.visit("p1");
        history.visit("p2");
        history.visit("p3");

        assertEquals("p2", history.goBack());
    }

    @Test
    void shouldReturnMsgWhenNoPreviousPage() {
        assertEquals("There is no page to go back", history.goBack());
    }

    @Test
    void goForwardShouldGiveLastPage() {
        history.visit("p1");
        history.visit("p2");
        history.visit("p3");
        history.goBack();

        assertEquals("p3", history.goForward());
    }

    @Test
    void shouldReturnMsgWhenNoLastPage() {
        assertEquals("There is no page to go fwd", history.goForward());
    }
}