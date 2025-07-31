package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.LightRangeWeapon;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.RangedWeapon;

public class LightCrossbow implements RangedWeapon {
    @Override
    public void shot() {
        System.out.println("Выстрел из легкого арбалета");
    }
}
