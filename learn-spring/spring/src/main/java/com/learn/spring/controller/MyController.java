package com.learn.spring.controller;

import com.learn.spring.service.MyService;
import com.learn.spring.service.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MyController {

    private final MyService myService;
    private final PaymentProcessor paymentProcessor;

    @Autowired
    public MyController(MyService myService, @Qualifier("card") PaymentProcessor processor) {
        this.myService = myService;
        this.paymentProcessor = processor;
    }
    @PostMapping("pay")
    public void pay() {
        paymentProcessor.processPayment();
    }

    @GetMapping("handle")
    public void handleRequest() {
        myService.serve();
    }
}
