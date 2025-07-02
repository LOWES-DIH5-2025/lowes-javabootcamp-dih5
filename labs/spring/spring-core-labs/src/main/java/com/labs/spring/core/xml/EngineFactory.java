package com.labs.spring.core.xml;

public class EngineFactory {

    public Engine createEngine(String type) {
        System.out.println("EngineFactory createEngine called with type: " + type);
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
