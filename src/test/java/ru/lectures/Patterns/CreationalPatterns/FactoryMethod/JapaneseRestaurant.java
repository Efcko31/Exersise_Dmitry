package ru.lectures.Patterns.CreationalPatterns.FactoryMethod;

public class JapaneseRestaurant extends Restaurant {
    Dish createDish() {
        return new Sushi();
    }
}
