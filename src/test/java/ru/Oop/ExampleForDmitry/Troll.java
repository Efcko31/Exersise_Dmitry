package ru.Oop.ExampleForDmitry;

import java.util.Random;

public class Troll extends Enemy{ // наследоватся надо только от одного класса
    public Troll(int hp) {
        super(hp);
    }

    @Override
    public void takeDamage(int damage) {
        this.hp = this.hp - damage;
        hp = hp + new Random().nextInt(1, 9);
    }
}
