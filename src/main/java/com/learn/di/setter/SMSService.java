package com.learn.di.setter;

// Service class (Dependency)
class SMSService {
    public void sendSMS(String message) {
        System.out.println("SMS sent with message: " + message);
    }
}
