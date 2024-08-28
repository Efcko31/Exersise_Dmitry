package ru.Oop.GameByEfcko.Person;

import ru.Oop.GameByEfcko.Armor.Armor;
import ru.Oop.GameByEfcko.Potions.HealthPotion;
import ru.Oop.GameByEfcko.Weapon.Weapon;

public class Warrior extends Person{
    protected HealthPotion healthPotion;


    public Warrior(String name, int totalHp, int nowHp, Armor armor, Weapon weapon) {
        super(name, totalHp, nowHp, armor, weapon);
        this.healthPotion = new HealthPotion("Маленькое зелье здоровья", 10, 20);
    }

    public void usePotion() {
        int numberHp = healthPotion.countNumberHp();
        System.out.printf("%s: использует %s +%d HP ", name, healthPotion.getName(), numberHp);
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
