package com.labs.sboot;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class Greetings {
    @Positive(message = "ID must be a positive number")
//    @Size(min = 1, max = 100, message = "ID must be between 1 and 100")
    private int id = 100;

    @NotBlank(message = "Message cannot be blank")
    @NotNull(message = "Message cannot be null")
    private String message = "Welcome to Spring Boot REST!!";

    public Greetings() {
    }

    public Greetings(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
