package ru.ArmyForKing.Horses;

import java.util.List;
import static ru.ArmyForKing.Utils.Constants.FEMALE_GENDER;
import static ru.ArmyForKing.Utils.Constants.MALE_GENDER;

public class AllHorses {

    public static Horse sivka = new Horse("Сивка", FEMALE_GENDER, 6);
    public static Horse lorik = new Horse("Лорик", MALE_GENDER, 8);
    public static Horse burka = new Horse("Бурка", FEMALE_GENDER, 5);
    public static Horse boris = new Horse("Борис", MALE_GENDER, 9);
    public static Horse gungnir = new Horse("Гунгнир", FEMALE_GENDER, 11);

    List<Horse> horseStall = List.of(sivka, lorik, boris, burka, gungnir);

}
