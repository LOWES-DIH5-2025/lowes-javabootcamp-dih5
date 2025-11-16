package com.labs.sboot.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/")
    public String greetings() {
        return "Hey! Welcome to Spring Security OAuth2 Training";
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User user) {
        return "Hello, " + user.getAttribute("login") + "!";
    }
}
