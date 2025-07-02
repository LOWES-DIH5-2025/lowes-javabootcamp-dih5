package com.labs.spring.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    // http:://localhost:8080/spring-rest-labs

//    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping(path = "/")
    public String greetings() {
        return "Welcome to Spring REST!!";
    }
}
