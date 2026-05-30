package ru.lectures.Patterns.StructuralPatterns.Decorator;

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

     public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
}
