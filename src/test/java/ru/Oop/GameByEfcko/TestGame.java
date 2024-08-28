package ru.Oop.GameByEfcko;

import ru.Oop.GameByEfcko.Armor.Armor;
import ru.Oop.GameByEfcko.Enemies.Troll;
import ru.Oop.GameByEfcko.Person.Warrior;
import ru.Oop.GameByEfcko.Weapon.Weapon;
import org.junit.jupiter.api.Test;

public class TestGame {
    Armor ironArmor = new Armor(15);
    Armor copperArmor = new Armor(5);
    Armor trollSkin = new Armor(25);
    Weapon copperSword = new Weapon("Медный меч", 5, 15);
    Weapon ironSword = new Weapon("Железный меч", 10, 25);
    Weapon blockhead = new Weapon("Дубина", 20, 35);
    Weapon diabloSword = new Weapon("Дьявольский мечЪ!", 50, 80);
    Warrior war1 = new Warrior("Gnorg", 150, 150, copperArmor, copperSword);

    Troll troll1 = new Troll("Троль", 200, 200, trollSkin, blockhead);

    @Test
    public void testBattle() {
        int round = 0;
        war1.useNewWeapon(ironSword);
        war1.useNewArmor(ironArmor);
        while (war1.isAlive() & troll1.isAlive()) {
            round++;
            troll1.takeDamage(war1.damage());
            war1.takeDamage(troll1.damage());
            if (war1.getTotalHp() / 2 > war1.getNowHp()) {
                war1.usePotion();
            }
            System.out.println("\n");
        }
        System.out.printf("Бой окончен за %d раундов", round);
    }
}
