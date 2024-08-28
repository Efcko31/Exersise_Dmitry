package ru.Oop.GameByEfcko.Weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {
    protected String name;
    protected int minDamage;
    protected int maxDamage;
}
