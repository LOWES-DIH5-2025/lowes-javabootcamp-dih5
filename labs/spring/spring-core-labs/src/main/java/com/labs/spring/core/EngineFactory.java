package com.labs.spring.core;

public class EngineFactory {

    public Engine createEngine(String type) {
        switch (type.toLowerCase()) {
            case "petrol":
                return Engine.createPetrolEngine();
            case "electric":
                return Engine.createElectricEngine();
            case "diesel":
                return Engine.createDieselEngine();
            default:
                throw new IllegalArgumentException("Unknown engine type: " + type);
        }
    }
}
