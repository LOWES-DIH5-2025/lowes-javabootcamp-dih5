package com.labs.spring.core.annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
@Scope("prototype")
public class PetrolEngine extends Engine {
    public PetrolEngine() {
        this.setType("Petrol");
        this.setHorsepower(150);
        this.setTorque(15);
        System.out.println("PetrolEngine constructor called");
    }
}
