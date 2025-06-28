package ru.TEST;

public class Car extends Vehicle {
    public Car(int km) {
        super(km);
    }

    public static void printNameVehicle(int km) {
        System.out.println("Машина!" + km);
    }
}
