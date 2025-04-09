package ru.ArmyForKing.Weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

import static ru.ArmyForKing.Weapon.anArsenalOfOneHandWeapon.anArsenalOfOneHandIronWeapon;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneHandedWeapon {

    private String name;
    private Integer damage;

    public OneHandedWeapon(OneHandedWeapon oneHandedWeapon) {
        this.name = oneHandedWeapon.getName();
        this.damage = oneHandedWeapon.getDamage();
    }


}
