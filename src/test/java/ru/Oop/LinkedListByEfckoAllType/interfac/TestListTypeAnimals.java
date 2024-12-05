package ru.Oop.LinkedListByEfckoAllType.interfac;

import org.junit.jupiter.api.Test;
import ru.Oop.Animals.Animal.Animal;
import ru.Oop.Animals.Animal.OthersAnimals.Bear;
import ru.Oop.Animals.Animal.OthersAnimals.Grizzly;
import ru.Oop.Animals.Animal.TheFelineFamily.Cat;
import ru.Oop.Animals.Animal.TheCanineFamily.Dog;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestListTypeAnimals {
    @Test
    void checkAddAnElementToLinkedListByEfckoTypeImpl() {
        assertArrayEquals(new String[]{"Бусенка", "Барсик","Миша", "Шарик", "Тузик"}, addElementsToArray());
    }

    public String[] addElementsToArray() {
        Cat barsik = new Cat("Мэйнкун","Барсик",
                "м",
                2,
                15,
                "бурый",
                new ArrayList<>(),
                "Покладистый, аккуратный, агрессии не наблюдается. На прививки реагирует нормально");

        Dog tuzic = new Dog("Пудель",
                "Тузик",
                "ж",
                1,
                13,
                "белый",
                new ArrayList<>(),
                "Покладистый, аккуратный, агрессии не наблюдается. На прививки реагирует нормально");

        Dog sharic = new Dog("Метис",
                "Шарик",
                "ж",
                1,
                13,
                "белый",
                new ArrayList<>(),
                "Покладистый, аккуратный, агрессии не наблюдается. На прививки реагирует нормально");

        Cat bosenka = new Cat("Домус",
                "Бусенка",
                "м",
                2,
                15,
                "бурый",
                new ArrayList<>(),
                "Покладистая, пугливая, агрессии не наблюдается. На прививки реагирует с небольшим испугом");

        Bear grizzly = new Bear("Гризли",
                "Миша",
                "м",
                5,
                270,
                "Темный",
                new ArrayList<>(),
                "Дикий. На прививки реагирует аггресивно. Найден в сети ресторанов КФС.");

        LinkedListByEfckoTypeImpl<Animal> animal2024years = new LinkedListByEfckoTypeImpl<>();
        animal2024years.add(bosenka);
        animal2024years.add(barsik);
        animal2024years.add(sharic);
        animal2024years.add(tuzic);
        animal2024years.add(2, grizzly);

        String[] ListAnimals = new String[animal2024years.size()];

        for (int i = 0; i < animal2024years.size(); i++) {
            ListAnimals[i] = animal2024years.get(i).getName();
        }
        return ListAnimals;
    }

    @Test

}
