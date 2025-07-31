package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.HeavyRangeWeapon.HeavyRangeWeaponsFactory;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.LightRangeWeapon.LightRangeWeaponsFactory;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.OneHandedWeapon.OneHandedFactory;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory.TwoHandedWeapon.TwoHandedFactory;

public class WeaponFactoryTest {
    public static void main(String[] args) {
        RangerWeaponFactory heavyRangedWeaponFactory = new HeavyRangeWeaponsFactory();
        RangerWeaponFactory lightRangeWeaponsFactory = new LightRangeWeaponsFactory();
        RangedWeapon lightBow = lightRangeWeaponsFactory.createRangedWeapon("лУк");
        RangedWeapon lightCrossbow = lightRangeWeaponsFactory.createRangedWeapon("арбалет");
        RangedWeapon heavyBow = heavyRangedWeaponFactory.createRangedWeapon("лУк");
        RangedWeapon heavyCrossbow = heavyRangedWeaponFactory.createRangedWeapon("арбалет");
        lightBow.shot();
        lightCrossbow.shot();
        heavyBow.shot();
        heavyCrossbow.shot();

        MeleeWeaponFactory oneHandedFactory = new OneHandedFactory();
        MeleeWeaponFactory twoHandedFactory = new TwoHandedFactory();
        MeleeWeapon oneHandedAxe = oneHandedFactory.createMeleeWeapon("топоР");
        MeleeWeapon oneHandedSword = oneHandedFactory.createMeleeWeapon("меч");
        MeleeWeapon twoHandedAxe = twoHandedFactory.createMeleeWeapon("топоР");
        MeleeWeapon twoHandedSword = twoHandedFactory.createMeleeWeapon("меч");
        oneHandedAxe.strike();
        oneHandedSword.strike();
        twoHandedAxe.strike();
        twoHandedSword.strike();

    }
}
