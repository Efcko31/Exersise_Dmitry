package ru.lectures.Patterns.CreationalPatterns.Builder;

public class Builder {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .withDough("Тонкое")
                .withSauce("томатный")
                .addTopping("грибы")
                .addTopping("сыр")
                .build();

        System.out.println( pizza.toString() );
    }
}
