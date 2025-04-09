package ru.ArmyForKing.Utils;

import ru.ArmyForKing.DescriptionOfSolder;
import ru.ArmyForKing.Units.Archer;
import ru.ArmyForKing.Units.Cavalry;
import ru.ArmyForKing.Units.Infantryman;


public class ArmyForKingService {


    public static DescriptionOfSolder descriptionOfSolderArcher(Archer archer) {
        return new DescriptionOfSolder(
                archer.getFirstName(),
                archer.getLastName(),
                archer.getPatronymic(),
                "1-й стрелковый взвод",
                "Рядовой",
                archer.getWeapon().getName() + " " + archer.getArmor().getName());
    }

    public static DescriptionOfSolder descriptionOfSolderCavalry(Cavalry cavalry) {
        return new DescriptionOfSolder(cavalry.getFirstName(),
                cavalry.getLastName(),
                cavalry.getPatronymic(),
                "2-й квалерийский взвод","рядовой",
                cavalry.getWeapon().getName() + " " + cavalry.getArmor().getName() + " " +
                        "Боевая лошадь: " + cavalry.getWarHorse().getName());

    }



}
