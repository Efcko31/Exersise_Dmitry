package ru.Oop.Animals.Animal.Dogs;

import ru.Oop.Animals.Animal.Animal;

import java.util.ArrayList;

public abstract class Dog extends Animal {
    public Dog(String name, String gender, Integer age, Integer weight, String color, ArrayList<String> diet, String description) {
        super(name, gender, age, weight, color, diet, description);
    }
    @Override
    public abstract String makeNoise();

    @Override
    public abstract void eat();

    @Override
    public abstract String getDescription();
}
