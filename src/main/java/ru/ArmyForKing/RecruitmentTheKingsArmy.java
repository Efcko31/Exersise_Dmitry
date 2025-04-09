package ru.ArmyForKing;

import ru.ArmyForKing.Mappers.toArcherMapper;
import ru.ArmyForKing.Mappers.toCavalryMapper;
import ru.ArmyForKing.Mappers.toInfantrymanMapper;
import ru.ArmyForKing.Units.Archer;
import ru.ArmyForKing.Units.Cavalry;
import ru.ArmyForKing.Units.Infantryman;
import ru.ArmyForKing.Units.Peasant;


import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static ru.ArmyForKing.Armor.anArsenalArmors.*;
import static ru.ArmyForKing.Utils.Constants.*;
import static ru.ArmyForKing.Weapon.anArsenalOfOneHandWeapon.anArsenalOfOneHandIronWeapon;
import static ru.ArmyForKing.Weapon.anArsenalOfOneHandWeapon.steelSpear;
import static ru.ArmyForKing.Weapon.anArsenalOfTwoHandedHandguns.longBow;

public class RecruitmentTheKingsArmy {

    public static List<Infantryman> recruitsInfantryIntoArmy(List<Peasant> peasants) {
        if (!peasants.isEmpty()) {
            List<Infantryman> newPlatoon = peasants.stream()
                    .filter(p -> MALE_GENDER.equals(p.getGender()) &&
                            p.getAge() < MAXIMUM_AGE && p.getHealthAssessment() > AVERAGE_HEALTH_STATUS &&
                            p.getHealthAssessment() < EXCELLENT_STATE_OF_HEALTH)
                    .map(p -> toInfantrymanMapper.INSTANCE.toInfantryman(p,
                            anArsenalOfOneHandIronWeapon.get(new Random().nextInt(anArsenalOfOneHandIronWeapon.size())),
                            ironArmor))
                    .collect(Collectors.toList());
            System.out.print("Призваны в пехоту: ");
            newPlatoon.forEach(i -> System.out.format("%s %s; ", i.getFirstName(), i.getLastName()));
            System.out.print("\n");
            return newPlatoon;

        } else {
            System.out.println("Не может быть, что-бы совсем никого не было! Отправить отряд для проверки в деревни!");
            return Collections.emptyList();
        }
    }

    public static List<Archer> recruitsArcherIntoArmy(List<Peasant> peasants) {
        if (!peasants.isEmpty()) {
            List<Archer> newPlatoon = peasants.stream().
                    filter(i -> MALE_GENDER.equals(i.getGender()) &&
                            i.getAge() < MAXIMUM_AGE &&
                            i.getHealthAssessment() > MINIMAL_HEALTH_STATUS &&
                            i.getHealthAssessment() <= AVERAGE_HEALTH_STATUS).
                    map(p -> toArcherMapper.INSTANCE.toArcher(p, longBow, LEATHER_ARMOR)).
                    collect(Collectors.toList());
            System.out.print("Призваны в отряды лучников: ");
            newPlatoon.forEach(i -> System.out.format("%s %s; ", i.getFirstName(), i.getLastName()));
            System.out.print("\n");
            return newPlatoon;
        } else {
            System.out.println("Не может быть, что-бы совсем никого не было! Отправить отряд для проверки в деревни!");
            return Collections.emptyList();
        }
    }

    public static List<Cavalry> recruitsCavalryIntoArmy(List<Peasant> peasants) {
        if (!peasants.isEmpty()) {

            return peasants.stream().
                    filter(i -> MALE_GENDER.equals(i.getGender()) &&
                            i.getAge() < MAXIMUM_AGE &&
                            i.getHealthAssessment() > EXCELLENT_STATE_OF_HEALTH).
                    map(p -> toCavalryMapper.INSTANCE.toCavalry(p, steelSpear, steelArmor)).
                    collect(Collectors.toList());
        } else {
            System.out.println("Не может быть, что-бы совсем никого не было! Отправить отряд для проверки в деревни!");
            return Collections.emptyList();
        }
    }


    public static boolean equalsAll(List<Peasant> expected, List<? extends Peasant> actual) {
        if (expected.size() != actual.size()) {
            return false;
        } else {
            return expected.stream().anyMatch(l1 -> actual.stream().anyMatch(l1::equals));
        }
    }
}
