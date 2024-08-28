package ru.Oop.GameByEfcko.Potions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthPotion {
    protected String name;
    protected int minHp;
    protected int maxHp;

    public int countNumberHp() {
        return new Random().nextInt(minHp, maxHp);
    }

}
