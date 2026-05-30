package ru.Oop.FightForEnum;

public class FightForEnumUtil {
    public static void killPlayer(Player player, EnemiesEnum enemiesEnum) {
        switch (enemiesEnum) {
            case SLIME:
                System.out.println(player.getGender().equalsIgnoreCase("м") ?
                        player.getName() + " растворен в кислоте." :
                        player.getName() + " растворена в кислоте.");
                break;
            case GOBLIN:
                System.out.println(player.getGender().equalsIgnoreCase("м") ?
                        player.getName() + " изрезан кривым кинжалом." :
                        player.getName() + " изрезана кривым кинжалом.");
                break;
            case BASILISK:
                System.out.println(player.getGender().equalsIgnoreCase("м") ?
                        player.getName() + " превращен в камень." :
                        player.getName() + " превращена в камень.");
                break;

            case VAMPIRE:
                System.out.println(player.getGender().equalsIgnoreCase("м") ?
                        player.getName() + " был обезкровлен!" :
                        player.getName() + " был обезкровлена!");
                break;

            case DARK_EXECUTIONER:
                System.out.println(player.getGender().equalsIgnoreCase("м") ?
                        player.getName() + " обезглавлен." :
                        player.getName() + " обезглавлена.");
                break;

        }
    }
}
