package com.learn.di.setter;

// Main class
public class SetterInjectionExample {
    public static void main(String[] args) {
        // Create client and dependency objects
        SMSService smsService = new SMSService();
        Notification notification = new Notification();

        // Inject the dependency
        notification.setSmsService(smsService);

        notification.notifyUser("Hello, Setter Injection!");
    }
}
