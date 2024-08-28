package ru.Oop.ExampleForDmitry;

import java.util.Random;

public class Zombie extends Enemy {

    public Zombie(int hp) {
        super(hp);
    }

    @Override
    public boolean isAlive() {
        return hp > 0 || takeChanceToSurvive();
    }

    private boolean takeChanceToSurvive(){
        return new Random().nextInt(1, 100) <= 50;
    }
}
