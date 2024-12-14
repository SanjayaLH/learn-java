package com.learn.questions.oop.q2;

public class FileLogger implements Logger {

    public void log(String message) {
        System.out.println("File logger" + message);
    }
}
