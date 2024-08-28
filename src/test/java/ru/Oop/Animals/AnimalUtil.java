package ru.Oop.Animals;

import ru.Oop.Animals.Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalUtil {
    protected static void addAnimalsToList(ArrayList<Animal> animalList, Animal... animals) {
        animalList.addAll(List.of(animals));
    }
}
