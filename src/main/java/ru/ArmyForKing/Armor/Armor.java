package ru.ArmyForKing.Armor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Armor {
    private String name;
    private Integer strength;

    public Armor(Armor armor) {
        this.name = armor.getName();
        this.strength = armor.getStrength();
    }
}
