package com.learn.di.constructor;

// Main class
public class ConstructorInjectionExample {
    public static void main(String[] args) {
        // Manually injecting the dependency
        EmailService emailService = new EmailService();
        Notification notification = new Notification(emailService);

        notification.notifyUser("Hello, Dependency Injection!");
    }
}
