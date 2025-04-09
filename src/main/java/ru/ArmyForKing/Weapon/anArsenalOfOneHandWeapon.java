package ru.ArmyForKing.Weapon;

import java.util.List;
import java.util.Random;

public class anArsenalOfOneHandWeapon {
    public static OneHandedWeapon ironSword = new OneHandedWeapon("Железный меч", 10);
    public static OneHandedWeapon ironAxe = new OneHandedWeapon("Железный топор", 15);
    public static OneHandedWeapon ironMace = new OneHandedWeapon("Железная булава", 20);
    public static OneHandedWeapon ironSpear = new OneHandedWeapon("Железное копье", 17);
    public static OneHandedWeapon steelSword = new OneHandedWeapon("Стальной меч", 20);
    public static OneHandedWeapon steelAxe = new OneHandedWeapon("Стальной топор", 25);
    public static OneHandedWeapon steelMace = new OneHandedWeapon("Стальная булава", 30);
    public static OneHandedWeapon steelSpear = new OneHandedWeapon("Стальное копье", 27);
    public static Shields woodShield = new Shields("Деервянный щит", 20);
    public static Shields ironShield = new Shields("Железный щит", 30);
    public static Shields steelShield = new Shields("Стальной щит", 40);


    public static List<OneHandedWeapon> anArsenalOfOneHandIronWeapon = List.of(ironSword, ironAxe, ironMace, ironSpear);

    public static List<OneHandedWeapon> anArsenalOfOneHandSteelWeapon = List.of(steelSword, steelSpear, steelAxe,
            steelMace);

    public static OneHandedWeapon setOneHandedWeapon() {
        return new OneHandedWeapon(anArsenalOfOneHandIronWeapon.get(new Random().nextInt(anArsenalOfOneHandIronWeapon.size())));
    }

}
