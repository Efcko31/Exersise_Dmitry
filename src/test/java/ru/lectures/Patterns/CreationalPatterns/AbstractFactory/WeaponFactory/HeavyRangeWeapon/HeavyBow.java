package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.HeavyRangeWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.RangedWeapon;

public class HeavyBow implements RangedWeapon {
    @Override
    public void shot() {
        System.out.println("Выстрел из тяжелого лука");
    }
}
