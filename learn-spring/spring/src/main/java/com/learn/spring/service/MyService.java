package com.learn.spring.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {
    public void serve() {
        System.out.println("Service is running...");
    }
}
