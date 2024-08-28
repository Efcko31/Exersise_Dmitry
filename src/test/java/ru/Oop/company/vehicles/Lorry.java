package ru.Oop.company.vehicles;

import ru.Oop.company.details.Engine;
import ru.Oop.company.professions.Driver;

public class Lorry extends Car {
    protected int payload;

    public Lorry(String brand,
                 String classCar,
                 Integer weight,
                 Driver driver,
                 Engine engine,
                 Integer payload) {
        super(brand, classCar, weight, driver, engine);

        this.payload = payload;
    }
}
