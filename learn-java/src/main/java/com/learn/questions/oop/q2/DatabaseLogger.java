package com.learn.questions.oop.q2;

public class DatabaseLogger implements Logger {
    public void log(String message) {
        System.out.println("Database Logger" + message);
    }
}
