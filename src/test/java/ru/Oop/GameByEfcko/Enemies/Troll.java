package ru.Oop.GameByEfcko.Enemies;

import ru.Oop.GameByEfcko.Armor.Armor;
import ru.Oop.GameByEfcko.Weapon.Weapon;

import java.util.Random;

public class Troll extends Enemy{
    public Troll(String name, int totalHp, int nowHp, Armor armor, Weapon weapon ) {
        super(name, totalHp, nowHp, armor, weapon);
    }
    @Override
    public void takeDamage(int damage) {
        this.nowHp -= damage;
        int regeneration = new Random().nextInt(3, 6);
        System.out.printf("%s: %d/%d HP\n", name, totalHp, nowHp);

        nowHp += regeneration;
        System.out.printf("%s: регенирует +%d HP. ", name, regeneration);
        System.out.printf("%s: %d/%d HP\n", name, totalHp, nowHp);
    }
}
