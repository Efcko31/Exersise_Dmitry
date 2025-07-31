package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.ItalianRestaurant;

abstract class Restaurant {
    abstract Dish createDish();

    void serveDish() {
        Dish dish = createDish();
        dish.cook();
    }
}
