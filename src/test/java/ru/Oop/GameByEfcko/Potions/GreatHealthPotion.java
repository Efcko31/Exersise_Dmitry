package ru.Oop.GameByEfcko.Potions;

import lombok.Getter;

import java.util.Random;

public class GreatHealthPotion extends HealthPotion {
    @Getter
    protected final static String NAME = "Большое зелье здоровья";
    protected final static Integer MINHP = 30;
    protected final static Integer MAXHP = 40;

    public static Integer countNumberHP() {
        return new Random().nextInt(MINHP, MAXHP);
    }
}
