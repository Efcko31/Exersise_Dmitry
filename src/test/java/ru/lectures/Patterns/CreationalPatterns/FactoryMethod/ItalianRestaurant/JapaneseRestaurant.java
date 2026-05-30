package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.ItalianRestaurant;

public class JapaneseRestaurant extends Restaurant {
    Dish createDish() {
        return new Sushi();
    }
}
