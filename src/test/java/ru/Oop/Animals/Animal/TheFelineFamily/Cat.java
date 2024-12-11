package ru.Oop.Animals.Animal.TheFelineFamily;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.Oop.Animals.Animal.Animal;

import java.util.ArrayList;
@Data
@EqualsAndHashCode(callSuper = true)
public class Cat extends Animal {
    public Cat(String breed, String name, String gender, Integer age, Integer weight, String color, ArrayList<String> diet, String note) {
        super(breed, name, gender, age, weight, color, diet, note);
    }

    @Override
    public String makeNoise() {
        return "Мяу!\n";
    }

    @Override
    public void eat() {
        for (String food : diet) {
            System.out.println(food);
        }
    }

    @Override
    public String getDescription() {
        return String.format("\nПол: %s;\nВозраст: %d;\nВес: %d;\nОкрас: %s;\nПримечание: %s.\n",
                gender, age, weight, color, note);
    }

}
