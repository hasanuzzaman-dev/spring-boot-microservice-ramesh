package com.hasan.employeeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value(value = "${spring.boot.message:Default Message}")
    private String message;

    @GetMapping("/user/message")
    private String  getMessage() {
        System.out.printf("message: %s", message);
        return message;
    }

    @PostMapping("/refresh")
    public String refreshAndLog() {
        System.out.printf("message after refresh: %s%n", message);
        return message;
    }

}
