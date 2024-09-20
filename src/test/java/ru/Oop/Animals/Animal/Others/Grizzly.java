package ru.Oop.Animals.Animal.Others;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Grizzly extends Bear {

    public Grizzly(String name, String gender, Integer age, Integer weight, String color, ArrayList<String> diet, String note) {
        super(name, gender, age, weight, color, diet, note);
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
