package com.labs.sboot;


import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

//@Component
@Data
@Builder
public class Greetings {
    private int id;
    private String message;
}
