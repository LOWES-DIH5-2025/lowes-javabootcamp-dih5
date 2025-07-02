package com.labs.spring.core.jconfig;

import org.springframework.stereotype.Component;

public class DieselEngine extends Engine {

    public DieselEngine() {
        this.setType("Diesel");
        this.setHorsepower(200);
        this.setTorque(30);
        System.out.println("DieselEngine constructor called");
    }
}
