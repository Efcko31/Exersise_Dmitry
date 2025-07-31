package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.OneHandedWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.MeleeWeapon;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.MeleeWeaponFactory;

public class OneHandedFactory implements MeleeWeaponFactory {
    @Override
    public MeleeWeapon createMeleeWeapon(String type) {
        switch (type.toLowerCase()) {
            case "топор" -> {
                return new OneHandedAxe();
            }
            case "меч" -> {
                return new OneHandedSword();
            }
            default -> throw new RuntimeException("Не распознан тип одноручного оружия");
        }
    }
}
