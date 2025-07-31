package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.ItalianRestaurant;

public class ItalianRestaurant extends Restaurant {
    @Override
    Dish createDish() {
        return new Pasta();
    }

}
