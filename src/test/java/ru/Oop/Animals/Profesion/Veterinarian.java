package ru.Oop.Animals.Profesion;

import ru.Oop.Animals.Animal.Animal;
import ru.Oop.Animals.Person;

import java.time.LocalDate;

public class Veterinarian extends Person {
    public Veterinarian(String firstName, String lastName, String patronymic, int age, LocalDate dateOfBirth) {
        super(firstName, lastName, patronymic, age, dateOfBirth);
    }

    public void treatAnimal(Animal animal) {
        System.out.println(animal.getDescription());
    }

}
