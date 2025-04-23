package ru.ArmyForKing.Weapon;

import lombok.Getter;
import ru.ArmyForKing.Armor.Armor;

import java.util.List;
import java.util.Random;

@Getter
public enum AnArsenalOfOneHandWeapon {
    IRON_SWORD  (new OneHandedWeapon("Железный меч", 10)),
    IRON_AXE  (new OneHandedWeapon("Железный топор", 15)),
    IRON_MACE  (new OneHandedWeapon("Железная булава", 20)),
    IRON_SPEAR  (new OneHandedWeapon("Железное копье", 17)),
    STEEL_SWORD  (new OneHandedWeapon("Стальной меч", 20)),
    STEEL_AXE  (new OneHandedWeapon("Стальной топор", 25)),
    STEEL_MACE  (new OneHandedWeapon("Стальная булава", 30)),
    STEEL_SPEAR  (new OneHandedWeapon("Стальное копье", 27));
//    public static Shields WOOD_SHIELD = new Shields("Деервянный щит", 20);
//    public static Shields IRON_SHIELD = new Shields("Железный щит", 30);
//    public static Shields STEEL_SHIELD = new Shields("Стальной щит", 40);
    private final OneHandedWeapon oneHandedWeapon;

    AnArsenalOfOneHandWeapon (OneHandedWeapon oneHandedWeapon) { this.oneHandedWeapon = oneHandedWeapon; }


    public static final List<AnArsenalOfOneHandWeapon> AN_ARSENAL_OF_ONE_HAND_IRON_WEAPON = List.of(IRON_SWORD, IRON_AXE, IRON_MACE, IRON_SPEAR);

    public static List<AnArsenalOfOneHandWeapon> AN_ARSENAL_OF_ONE_HAND_STEEL_WEAPON = List.of(STEEL_SWORD, STEEL_SPEAR, STEEL_AXE,
            STEEL_MACE);



//    public static OneHandedWeapon setOneHandedWeapon() {
//        return new OneHandedWeapon(AN_ARSENAL_OF_ONE_HAND_IRON_WEAPON.get(new Random().nextInt(AN_ARSENAL_OF_ONE_HAND_IRON_WEAPON.size())));
//    }

}
