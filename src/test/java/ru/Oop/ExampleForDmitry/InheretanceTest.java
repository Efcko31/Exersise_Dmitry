package ru.Oop.ExampleForDmitry;

import org.junit.jupiter.api.Test;

public class InheretanceTest {



    @Test
    public void testEnemy() {
        Enemy enemy = new Enemy(100);
        int round = 0;
        while (enemy.isAlive()) {
            enemy.takeDamage(10);
            round++;
        }
        System.out.printf("победа за %d раундов ", round);
    }

    @Test
    public void testTroll() {
        Troll enemy = new Troll(100);
        int round = 0;
        while (enemy.isAlive()) {
            enemy.takeDamage(10);
            round++;
        }
        System.out.printf("победа за %d раундов ", round);
    }

    @Test
    public void testZombie() {
        Zombie enemy = new Zombie(100);
        int round = 0;
//        enemy.takeChanceToSurvive вне класса не доступно
        while (enemy.isAlive()) {
            enemy.takeDamage(10);
            round++;
        }
        System.out.printf("победа за %d раундов ", round);
    }
}
