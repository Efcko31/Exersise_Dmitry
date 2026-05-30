package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.TwoHandedWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.MeleeWeapon;

public class TwoHandedSword implements MeleeWeapon {
    @Override
    public void strike() {
        System.out.println("Удар двуручным мечом");
    }
}
