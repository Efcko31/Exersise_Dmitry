package ru.Oop.FightForEnum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static ru.Oop.FightForEnum.EnemiesEnum.*;

public class FightForEnumTest {
    public ArrayList<EnemiesEnum> enemyArray = new ArrayList<>();
    Player aragorn = new Player("Арагорн", "м");
    Player beatris = new Player("Беатрис", "ж");

    @Test
    void test() {
        enemyArray.add(SLIME);
        enemyArray.add(GOBLIN);
        enemyArray.add(BASILISK);
        enemyArray.add(VAMPIRE);
        enemyArray.add(DARK_EXECUTIONER);

        aragorn.playerDeath(enemyArray.get(new Random().nextInt(5)));
        beatris.playerDeath(enemyArray.get(new Random().nextInt(5)));

        FightForEnumUtil.killPlayer(aragorn, SLIME);
        FightForEnumUtil.killPlayer(beatris, DARK_EXECUTIONER);
    }

}
