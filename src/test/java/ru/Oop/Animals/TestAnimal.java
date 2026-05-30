package ru.Oop.Animals;

import ru.Oop.Animals.Animal.Animal;
import ru.Oop.Animals.Animal.TheFelineFamily.MaineCoon;
import ru.Oop.Animals.Animal.TheCanineFamily.Poodle;
import ru.Oop.Animals.Animal.OthersAnimals.Grizzly;
import ru.Oop.Animals.Profesion.Veterinarian;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestAnimal {
    ArrayList<Animal> animals;
    Veterinarian veterinarian = new Veterinarian(
            "Михаил",
            "Федоров",
            "Иванов",
            32,
            LocalDate.of(1992, 12, 24));
    MaineCoon maineCoon = new MaineCoon("Мэйнкун",
            "Барсик",
            "м",
            2,
            15,
            "бурый",
            new ArrayList<>(),
            "Покладистый, аккуратный, агрессии не наблюдается. На прививки реагирует нормально");
    Poodle poodle = new Poodle("Пудель",
            "Тузик",
            "ж",
            1,
            13,
            "белый",
            new ArrayList<>(),
            "Покладистый, аккуратный, агрессии не наблюдается. На прививки реагирует нормально");
    Grizzly grizzly = new Grizzly("Гризли",
            "Миша",
            "м",
            5,
            270,
            "Темный",
            new ArrayList<>(),
            "Дикий. На прививки реагирует аггресивно. Найден в сети ресторанов КФС.");


    @Test
    public void test() {
        animals = new ArrayList<>();
        animals.add(maineCoon);
        animals.add(poodle);
        animals.add(grizzly);

        maineCoon.getDiet().add("Мягкий корм");
        maineCoon.getDiet().add("Сухой корм");
        maineCoon.getDiet().add("Молоко");

        poodle.getDiet().add("Сухой корм");
        poodle.getDiet().add("Курица отварная");
        poodle.getDiet().add("Комплекс витаминов");

        grizzly.getDiet().add("Конина свежая");
        grizzly.getDiet().add("Свинина свежая");
        grizzly.getDiet().add("Мед");

        for (Animal animal : animals) {
            System.out.println(animal.getName());
            veterinarian.treatAnimal(animal);
        }
        for (Animal animal : animals) {
            animal.eat();
            System.out.println(animal.makeNoise());
        }
    }
}
