package com.example.greetingapplication.controller;

import com.example.greetingapplication.entity.NewUser;
import com.example.greetingapplication.entity.User;
import com.example.greetingapplication.service.IGreetingAppServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello")
public class GreetingController {
    @Autowired
    private  IGreetingAppServic greetingAppService;
    private static final String TEMPLATE = "Hello,%s";
    private static final AtomicLong counter = new AtomicLong();

    @GetMapping("/getmessage")
    public User sayHello(@RequestParam(value = "name", defaultValue = "Welcome") String name) {
        return new User(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @GetMapping("/get")
    public User sayHello() {
        return (User) greetingAppService.getMessage();
    }

    @PostMapping("/post")
    private User sayHello(@RequestBody NewUser newUser) {
        return (User) greetingAppService.greetingMessage(newUser);
    }
}
