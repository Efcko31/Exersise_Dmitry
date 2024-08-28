package ru.Oop.ExampleForDmitry;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Enemy {

    protected int hp;

    public void takeDamage(int damage) {
        hp = hp - damage;
    }

    public boolean isAlive() {
        return  hp > 0;
    }
}
