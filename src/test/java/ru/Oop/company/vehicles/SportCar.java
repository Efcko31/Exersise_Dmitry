package ru.Oop.company.vehicles;

import ru.Oop.company.details.Engine;
import ru.Oop.company.professions.Driver;

public class SportCar extends Car {
    protected int maxSpeed;

    public SportCar(String brand,
                    String classCar,
                    Integer weight,
                    Driver driver,
                    Engine engine,
                    Integer maxSpeed) {
        super(brand, classCar, weight, driver, engine);

        this.maxSpeed = maxSpeed;
    }
}
