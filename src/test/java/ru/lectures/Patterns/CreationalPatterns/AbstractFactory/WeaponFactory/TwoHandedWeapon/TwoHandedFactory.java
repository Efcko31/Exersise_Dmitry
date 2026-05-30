package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.TwoHandedWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.MeleeWeapon;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.MeleeWeaponFactory;

public class TwoHandedFactory implements MeleeWeaponFactory {
    @Override
    public MeleeWeapon createMeleeWeapon(String type) {
        switch (type.toLowerCase()) {
            case "топор" -> {
                return new TwoHandedAxe();
            }
            case "меч" -> {
                return new TwoHandedSword();
            }
            default -> throw new RuntimeException("Не распознан тип двуручного оружия");
        }
    }
}
