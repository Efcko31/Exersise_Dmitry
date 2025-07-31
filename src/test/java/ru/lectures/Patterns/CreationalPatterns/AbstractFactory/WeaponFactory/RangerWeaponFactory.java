package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.WeaponFactory;

public interface RangerWeaponFactory {
    RangedWeapon createRangedWeapon(String type);
}
