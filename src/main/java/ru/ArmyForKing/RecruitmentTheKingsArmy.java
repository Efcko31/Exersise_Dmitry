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

import static ru.ArmyForKing.Armor.AnArsenalArmors.*;
import static ru.ArmyForKing.Horses.AllHorses.SIVKA;
import static ru.ArmyForKing.Utils.Constants.*;
import static ru.ArmyForKing.Weapon.AnArsenalOfOneHandWeapon.AN_ARSENAL_OF_ONE_HAND_IRON_WEAPON;
import static ru.ArmyForKing.Weapon.AnArsenalOfOneHandWeapon.STEEL_SPEAR;
import static ru.ArmyForKing.Weapon.AnArsenalOfTwoHandedHandguns.LONG_BOW;

public class RecruitmentTheKingsArmy {

    public static List<Infantryman> recruitsInfantryIntoArmy(List<Peasant> peasants) {
        if (!peasants.isEmpty()) {
            List<Infantryman> newPlatoon = peasants.stream()
                    .filter(p -> MALE_GENDER.equals(p.getGender()) &&
                            p.getAge() < MAXIMUM_AGE && p.getHealthAssessment() > AVERAGE_HEALTH_STATUS &&
                            p.getHealthAssessment() < EXCELLENT_STATE_OF_HEALTH)
                    .map(p -> toInfantrymanMapper.INSTANCE.toInfantryman(p, AN_ARSENAL_OF_ONE_HAND_IRON_WEAPON
                                    .get(new Random().nextInt(AN_ARSENAL_OF_ONE_HAND_IRON_WEAPON.size()))
                                    .getOneHandedWeapon(),
                            IRON_ARMOR.getArmor()))
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
                    map(p -> toArcherMapper.INSTANCE.toArcher(p, LONG_BOW.getTwoHandedWeapons(),
                            LEATHER_ARMOR.getArmor())).
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

            List<Cavalry> newPlatoon = peasants.stream()
                    .filter(i -> MALE_GENDER.equals(i.getGender()) &&
                            i.getAge() < MAXIMUM_AGE &&
                            i.getHealthAssessment() > EXCELLENT_STATE_OF_HEALTH)
                    .map(p -> toCavalryMapper.INSTANCE.toCavalry(p, STEEL_SPEAR.getOneHandedWeapon(),
                            STEEL_ARMOR.getArmor()/*, SIVKA.getHorse()*/))
                    .collect(Collectors.toList());
            System.out.print("Призваны в отряды кавалерии: ");
            newPlatoon.forEach(i -> System.out.format("%s %s; ", i.getFirstName(), i.getLastName()));
            System.out.print("\n");
            return newPlatoon;
        } else {
            System.out.println("Не может быть, что-бы совсем никого не было! Отправить отряд для проверки в деревни!");
            return Collections.emptyList();
        }
    }

}
