package com.example.greetingapplication.service;

import com.example.greetingapplication.entity.NewUser;
import com.example.greetingapplication.entity.User;

public interface IGreetingAppServic {
    com.example.greetingapplication.entity.User getMessage();

    User greetingMessage(NewUser newUser);
}
