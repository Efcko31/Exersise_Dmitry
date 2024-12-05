package ru.Oop.Animals.Animal.OthersAnimals;

import ru.Oop.Animals.Animal.Animal;

import java.util.ArrayList;

public class Bear extends Animal {
    public Bear(String breed, String name, String gender, Integer age, Integer weight, String color, ArrayList<String> diet, String note) {
        super(breed, name, gender, age, weight, color, diet, note);
    }

    @Override
    public String makeNoise() {
        return "Уэээээээ!\n";
    }

    @Override
    public void eat() {
        for (String food : diet) {
            System.out.println(food);
        }
    }

    @Override
    public String getDescription() {
        return String.format("\nПол: %s;\nВозраст: %d;\nВес: %d;\nОкрас: %s;\nОписание: %s.\n",
                gender, age, weight, color, note);
    }
}
