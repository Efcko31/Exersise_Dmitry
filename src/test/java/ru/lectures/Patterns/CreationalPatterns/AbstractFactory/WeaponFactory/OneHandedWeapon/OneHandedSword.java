package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.OneHandedWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.MeleeWeapon;

public class OneHandedSword implements MeleeWeapon {
    @Override
    public void strike() {
        System.out.println("Удар одноручным мечом");
    }
}
