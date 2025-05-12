package ru.lectures.Patterns.CreationalPatterns.FactoryMethod;

public class Pasta implements Dish {
    @Override
    public void cook() {
        System.out.println("Готовим пасту...");
    }
}
