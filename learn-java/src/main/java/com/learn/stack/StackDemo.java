package com.learn.stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        demoStack();
    }

    public static void demoStack() {
        Stack<String> stack = new Stack<>();

        System.out.println("Before add items to Stack:"+stack.size());
        System.out.println("Before add items to Stack, empty?:"+stack.empty());

        stack.push("Akhya");
        stack.push("Kylie");
        stack.push("Rani");
        stack.push("Didu");

        System.out.println("After add items to Stack:"+stack.size());
        System.out.println("After add items to Stack empty:"+stack.isEmpty());
        System.out.println("Items of Stack:"+stack);

        System.out.println("Items of search Rani:"+stack.search("Rani"));
        System.out.println("Items of search Rani:"+stack.search("A"));

        stack.pop();
        System.out.println("Now pop :"+stack.pop());
        System.out.println("After pop items in Stack:"+stack);

        stack.peek();
        System.out.println("Now peek :"+stack.peek());
        System.out.println("After peek items in Stack:"+stack);

    }

}
