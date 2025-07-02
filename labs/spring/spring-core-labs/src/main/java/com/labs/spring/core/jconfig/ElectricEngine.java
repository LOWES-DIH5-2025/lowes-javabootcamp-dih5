package com.labs.spring.core.jconfig;

import org.springframework.stereotype.Component;

public class ElectricEngine extends Engine {
    public ElectricEngine() {
        setType("Electric");
        this.setHorsepower(300);
        this.setTorque(50);
        System.out.println("ElectricEngine constructor called");
    }
}
