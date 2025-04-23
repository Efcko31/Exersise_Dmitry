package ru.LinkedListByEfckoAllType.interfac;

import org.junit.jupiter.api.Test;
import ru.Impl.LinkedListByEfckoTypeImpl;
import ru.Oop.Animals.Animal.Animal;
import ru.Oop.Animals.Profesion.Veterinarian;

import java.time.LocalDate;

import static ru.Oop.Animals.Animal.TheCanineFamily.Canines.*;
import static ru.Oop.Animals.Animal.TheFelineFamily.Felines.*;

public class ExerciseAnimals {
    Veterinarian veterinarian = new Veterinarian(
            "Михаил",
            "Федоров",
            "Иванов",
            32,
            LocalDate.of(1992, 12, 24));
    @Test
    public void addsDietForEachAnimalAndPrintsEachAnimal() {

        LinkedListByEfckoTypeImpl<Animal> animals = new LinkedListByEfckoTypeImpl<>();
        animals.addAll(bosenka,stefa, sharic, shishunya, dimka);

        bosenka.getDiet().add("Мягкий корм");
        bosenka.getDiet().add("Сухой корм");
        bosenka.getDiet().add("Молоко");

        stefa.getDiet().add("Сухой корм");
        stefa.getDiet().add("Курица отварная");
        stefa.getDiet().add("Комплекс витаминов");

        shishunya.getDiet().add("Сухой корм");
        shishunya.getDiet().add("Курица отварная");
        shishunya.getDiet().add("Комплекс витаминов");

        dimka.getDiet().add("Сухой корм");
        dimka.getDiet().add("Курица отварная");
        dimka.getDiet().add("Комплекс витаминов");

        sharic.getDiet().add("Конина свежая");
        sharic.getDiet().add("Свинина свежая");
        sharic.getDiet().add("Мед");

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).getName());
            veterinarian.treatAnimal(animals.get(i));
        }
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).eat();
            System.out.println(animals.get(i).makeNoise());
        }
    }
}
