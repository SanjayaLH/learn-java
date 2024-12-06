package com.learn.di.setter;

// Client class
class Notification {
    private SMSService smsService;

    // Dependency is injected via setter
    public void setSmsService(SMSService smsService) {
        this.smsService = smsService;
    }

    public void notifyUser(String message) {
        smsService.sendSMS(message);
    }
}
