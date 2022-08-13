package com.example.greetingapplication.service;

import com.example.greetingapplication.entity.NewUser;
import com.example.greetingapplication.entity.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingAppService implements IGreetingAppServic{
    private static final String TEMPLATE = "Hello ,%s ";
    private static final AtomicLong count = new AtomicLong();

    @Override
    public User getMessage(){
        return new User (count.incrementAndGet(),String.format(TEMPLATE,"Amol"));
    }

    @Override
    public User greetingMessage(NewUser newUser) {
        return new User (count.incrementAndGet(), String.format(TEMPLATE, newUser.getFirstName()) + newUser.getLastName());
    }
}
