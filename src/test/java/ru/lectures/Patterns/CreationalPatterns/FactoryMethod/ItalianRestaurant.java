package ru.lectures.Patterns.CreationalPatterns.FactoryMethod;

public class ItalianRestaurant extends Restaurant {
    @Override
    Dish createDish() {
        return new Pasta();
    }

}
