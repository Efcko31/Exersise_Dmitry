package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.ItalianRestaurant;

public class Sushi implements Dish {
    @Override
    public void cook () {
        System.out.println("Готовим суши...");
    }
}
