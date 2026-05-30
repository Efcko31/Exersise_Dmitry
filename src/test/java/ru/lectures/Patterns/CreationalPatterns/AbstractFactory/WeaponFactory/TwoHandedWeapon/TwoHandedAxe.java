package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.TwoHandedWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.MeleeWeapon;

public class TwoHandedAxe implements MeleeWeapon {
    @Override
    public void strike() {
        System.out.println("Нанесен удар двуручным топором");
    }
}