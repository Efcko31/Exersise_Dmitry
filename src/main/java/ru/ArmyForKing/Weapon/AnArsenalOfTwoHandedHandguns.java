package ru.ArmyForKing.Weapon;

import lombok.Getter;

@Getter
public enum AnArsenalOfTwoHandedHandguns {
    LONG_BOW  (new TwoHandedWeapons("Длинный лук", 10));
    private final TwoHandedWeapons twoHandedWeapons;

    AnArsenalOfTwoHandedHandguns (TwoHandedWeapons twoHandedWeapons) { this.twoHandedWeapons = twoHandedWeapons; }
}
