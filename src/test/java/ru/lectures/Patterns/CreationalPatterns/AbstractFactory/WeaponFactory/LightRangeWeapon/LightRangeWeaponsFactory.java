package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.LightRangeWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.RangedWeapon;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.RangerWeaponFactory;

public class LightRangeWeaponsFactory implements RangerWeaponFactory {
    @Override
    public RangedWeapon createRangedWeapon(String type) {
        switch (type.toLowerCase()) {
            case "арбалет" -> {
                return new LightCrossbow();
            }
            case "лук" -> {
                return new LightBow();
            }
            default -> throw new RuntimeException("Нераспознан тип легкого дальнего оружия");
        }
    }
}
