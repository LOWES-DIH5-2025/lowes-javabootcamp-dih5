package com.labs.spring.core.jconfig;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class PetrolEngine extends Engine {
    public PetrolEngine() {
        this.setType("Petrol");
        this.setHorsepower(150);
        this.setTorque(15);
        System.out.println("PetrolEngine constructor called");
    }
}
