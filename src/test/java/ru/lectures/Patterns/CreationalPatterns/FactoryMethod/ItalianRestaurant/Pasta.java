package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.ItalianRestaurant;

public class Pasta implements Dish {
    @Override
    public void cook() {
        System.out.println("Готовим пасту...");
    }
}
