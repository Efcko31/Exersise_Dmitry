package ru.Oop.GameByEfcko.Potions;

import lombok.Getter;

import java.util.Random;

public class SmallHealthPotion extends HealthPotion {
    @Getter
    protected final static String NAME = "Маленькое зелье здоровья";
    protected final static Integer MINHP = 10;
    protected final static Integer MAXHP = 20;

    public static Integer countNumberHP() {
        return new Random().nextInt(MINHP, MAXHP);
    }
}
