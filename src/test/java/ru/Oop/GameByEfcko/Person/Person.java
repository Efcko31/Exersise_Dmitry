package ru.Oop.GameByEfcko.Person;

import ru.Oop.GameByEfcko.Armor.Armor;
import ru.Oop.GameByEfcko.Weapon.Weapon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    protected String name;
    protected int totalHp;
    protected int nowHp;
    protected Armor armor;
    protected Weapon weapon;

    public boolean isAlive() {
        if (nowHp < 0) {
            System.out.println(name + " мертв");
            return false;
        } else {
            return true;
        }
    }
    public void takeDamage(int damage) {
        nowHp -= (damage - armor.getArmor());
        System.out.printf("%s: %d/%d HP\n", name, totalHp, nowHp);
    }

    public int damage() {
        int damage = new Random().nextInt(weapon.getMinDamage(), weapon.getMaxDamage());
        System.out.printf("%s: наносит урон %d ед. ", name, damage);
        return damage;
    }
}
