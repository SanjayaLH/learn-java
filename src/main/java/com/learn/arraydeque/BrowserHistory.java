package com.learn.arraydeque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ArrayDeque is a double-ended queue, meaning it can add and remove elements from both the front and the back.
 * It's more efficient than LinkedList for stack (LIFO) and queue (FIFO) operations,
 * making it perfect for scenarios that need stack-like behavior.
 * <p>
 * Scenario: Browser History Navigation
 * In a browser, you can navigate backward and forward through a history of visited pages.
 * This behavior can be modeled using ArrayDeque with LIFO for back navigation.
 */
public class BrowserHistory {
    private ArrayDeque<String> back; //stack for backward items
    private ArrayDeque<String> fwd; //stack for forward items

    public BrowserHistory() {
        this.back = new ArrayDeque<>();
        this.fwd = new ArrayDeque<>();
    }

    public void visit(String newPage) {
        if (newPage == null || newPage.equals("")) {
            throw new IllegalArgumentException("cannot visit null pages");
        }
        if (!back.isEmpty()) {
            fwd.clear();
        }
        back.push(newPage);
    }

    public String goBack() {
        if (back.size() > 1) {
            String page = back.pop();
            fwd.push(page);
            return back.peek();
        } else {
            return "There is no page to go back";
        }
    }

    public String goForward() {
        if (!fwd.isEmpty()) {
            String page = fwd.pop();
            back.push(page);
            return page;
        } else {
            return "There is no page to go fwd";
        }
    }

    public static void main(String[] args) {

        BrowserHistory history = new BrowserHistory();

        history.visit("page 1");
        history.visit("page 2");
        history.visit("page 3");

        System.out.println("Go back to:" + history.goBack());
        System.out.println("Go back to:" + history.goBack());

        System.out.println("Go fwd to:" + history.goForward());
        System.out.println("Go fwd to:" + history.goForward());
    }
}
