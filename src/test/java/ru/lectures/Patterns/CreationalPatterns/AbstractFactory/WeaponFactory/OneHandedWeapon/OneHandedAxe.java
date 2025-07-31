package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.OneHandedWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.MeleeWeapon;

public class OneHandedAxe implements MeleeWeapon {
    @Override
    public void strike() {
        System.out.println("Нанесен удар одноручным топором");
    }
}
