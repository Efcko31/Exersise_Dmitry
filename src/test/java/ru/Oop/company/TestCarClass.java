package ru.Oop.company;

import ru.Oop.company.details.Engine;
import ru.Oop.company.professions.Driver;
import ru.Oop.company.vehicles.Lorry;
import ru.Oop.company.vehicles.SportCar;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestCarClass {
    Driver person1 = new Driver("Иванов",
            "Иван",
            "Иванович",
            23,
            LocalDate.of(2001, 5, 12),
            3);
    Driver person2 = new Driver("Петров",
            "Петр",
            "Петрович",
            25,
            LocalDate.of(1999, 12, 16),
            5);

    Driver personTestCorrect = new Driver("Максимов",
            "Максимм228",
            " Петро?аи",
            332,
            LocalDate.of(1992, 5, 30),
            2);

    Lorry lorry1 = new Lorry("КамАЗ",
            "Тяжелый",
            9850,
            person1,
            new Engine(730, "Россия"),
            4000);
    SportCar sportCar1 = new SportCar("Marussia B1",
            "S",
            1100,
            person2,
            new Engine(300, "Россия"),
            400);

    @Test
    public void testCar() {
        System.out.println(lorry1.toString());
        System.out.println(" ");
        System.out.println(sportCar1.toString());

        CarUtil.checkFullNameCorrect(personTestCorrect);

    }
}
