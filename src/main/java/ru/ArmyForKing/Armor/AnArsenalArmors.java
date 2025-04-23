package ru.ArmyForKing.Armor;

import lombok.Getter;

@Getter
public enum AnArsenalArmors {
     LEATHER_ARMOR ( new Armor("Кожанный комплект брони", 8)),
     IRON_ARMOR ( new Armor("Железный комплект брони", 10)),
     STEEL_ARMOR ( new Armor("Стальной комплект брони", 25));
     private final Armor armor;

     AnArsenalArmors(Armor armor) { this.armor = armor; }

}
