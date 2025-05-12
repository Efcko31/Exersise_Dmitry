package ru.lectures.Patterns.StructuralPatterns.Decorator;

public class Decorator {
    // Динамически добавляет новую функциональность объекту, не изменяя его класс.
    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());

        Coffee coffee2 = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(coffee2.getDescription());
        System.out.println(coffee2.getCost());
    }
}
