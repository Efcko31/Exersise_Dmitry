package ru.Oop.Animals.Animal.Cats;

import ru.Oop.Animals.Animal.Animal;

import java.util.ArrayList;

public abstract class Cat extends Animal {
    public Cat(String name, String gender, Integer age, Integer weight, String color, ArrayList<String> diet, String note) {
        super(name, gender, age, weight, color, diet, note);
    }
}
