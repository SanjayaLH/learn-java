package com.learn.di.constructor;

// Client class
class Notification {
    private final EmailService emailService;

    // Dependency is injected via constructor
    public Notification(EmailService emailService) {
        if (emailService == null){
            throw new IllegalArgumentException();
        }
        this.emailService = emailService;
    }

    public void notifyUser(String message) {
        emailService.sendEmail(message);
    }
}
