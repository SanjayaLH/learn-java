package com.learn.di.constructor;

// Service class (Dependency)
class EmailService {
    public void sendEmail(String message) {
        System.out.println("Email sent with message: " + message);
    }
}