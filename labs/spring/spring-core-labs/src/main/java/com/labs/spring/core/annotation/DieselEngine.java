package com.labs.spring.core.annotation;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine extends Engine{

    public DieselEngine() {
        this.setType("Diesel");
        this.setHorsepower(200);
        this.setTorque(30);
        System.out.println("DieselEngine constructor called");
    }
}
