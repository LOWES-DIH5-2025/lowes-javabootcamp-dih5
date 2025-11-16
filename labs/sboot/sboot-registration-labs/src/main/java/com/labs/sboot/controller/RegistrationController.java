package com.labs.sboot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.labs.sboot.model.RegistrationForm;

@RestController
public class RegistrationController {

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register(RegistrationForm form) {
        // Display and return all form details
        return "Registration successful! Details: " + form.toString();
    }
}
