package ru.Oop.GameByEfcko.Potions;

import lombok.Getter;

import java.util.Random;

public class AverageHealthPotion extends HealthPotion {
    @Getter
    protected final static String NAME = "Среднее зелье здоровья";
    protected final static Integer MINHP = 20;
    protected final static Integer MAXHP = 30;

    public static Integer countNumberHP() {
        return new Random().nextInt(MINHP, MAXHP);
    }
}
