package ru.Oop.FightForEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String name;
    private String gender;

    public void playerDeath(EnemiesEnum enemy) {
        if (gender.equalsIgnoreCase("м")) {
            System.err.println(name + enemy.getEnemy().getSomethingBadWithMan());
        } else if (gender.equalsIgnoreCase("ж")) {
            System.err.println(name + enemy.getEnemy().getSomethingBadWithWoman());
        }
    }

}
