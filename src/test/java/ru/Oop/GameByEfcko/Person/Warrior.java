package ru.Oop.GameByEfcko.Person;

import ru.Oop.GameByEfcko.Armor.Armor;
import ru.Oop.GameByEfcko.Backpack.Backpack;
import ru.Oop.GameByEfcko.Backpack.Bag;
import ru.Oop.GameByEfcko.Potions.HealthPotion;
import ru.Oop.GameByEfcko.Potions.SmallHealthPotion;
import ru.Oop.GameByEfcko.Weapon.Weapon;

public class Warrior extends Person{
    protected HealthPotion healthPotion;
    protected Backpack backpack;


    public Warrior(String name, int totalHp, int nowHp, Armor armor, Weapon weapon) {
        super(name, totalHp, nowHp, armor, weapon);
        this.healthPotion = new SmallHealthPotion();
        this.backpack = new Bag();
    }

    public void usePotion() {
        int numberHp = SmallHealthPotion.countNumberHP();
        System.out.printf("%s: использует %s +%d HP ", name, SmallHealthPotion.getNAME(), numberHp);
        nowHp += numberHp;
        System.out.printf("%s: %d/%d HP\n", name, totalHp, nowHp);
    }

    public void useNewWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void useNewArmor(Armor armor) {
        this.armor = armor;
    }
}
