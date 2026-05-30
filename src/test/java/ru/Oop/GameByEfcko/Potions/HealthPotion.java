package ru.Oop.GameByEfcko.Potions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class HealthPotion {
    protected String name;
    protected  Integer minHP;
    protected  Integer maxHP;
}
