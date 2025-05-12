package ru.lectures.Patterns.CreationalPatterns.FactoryMethod;

public class Sushi implements Dish {
    @Override
    public void cook () {
        System.out.println("Готовим суши...");
    }
}
