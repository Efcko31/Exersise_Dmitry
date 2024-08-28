package ru.Oop.Animals;

import ru.Oop.Animals.Animal.Animal;
import ru.Oop.Animals.Animal.Cats.MaineCoon;
import ru.Oop.Animals.Animal.Dogs.Poodle;
import ru.Oop.Animals.Animal.Others.Grizzly;
import ru.Oop.Animals.Profesion.Veterinarian;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestAnimal {
    ArrayList<Animal> animals = new ArrayList<>();
    Veterinarian vet = new Veterinarian(
            "Михаил",
            "Федоров",
            "Иванов",
            32,
            LocalDate.of(1992,12,24) );
    MaineCoon animal1 = new MaineCoon(
            "Барсик",
            "м",
            2,
            15,
            "бурый",
            new ArrayList<>(),
            "Покладистый, аккуратный, агрессии не наблюдается. На прививки реагирует нормально");
    Poodle animal2 = new Poodle(
            "Тузик",
            "ж",
            1,
            13,
            "белый",
            new ArrayList<>(),
            "Покладистый, аккуратный, агрессии не наблюдается. На прививки реагирует нормально");
    Grizzly animal3 = new Grizzly(
            "Миша",
            "м",
            5,
            270,
            "Темный",
            new ArrayList<>(),
            "Дикий. На прививки реагирует аггресивно. Найден в сети ресторанов КФС.");


    @Test
    public void test() {
        AnimalUtil.addAnimalsToList(animals, animal1, animal2, animal3);
        animal1.addDiet("Мягкий корм", "Сухой корм", "Молоко");
        animal2.addDiet("Сухой корм", "Курица отварная", "Комплекс витаминов");
        animal3.addDiet("Конина свежая", "Свинина свежая", "Мед");

        for (Animal animal : animals) {
            vet.treatAnimal(animal);
        }
        for (Animal animal : animals) {
            animal.eat();
            System.out.println(animal.makeNoise());
        }
    }
}
