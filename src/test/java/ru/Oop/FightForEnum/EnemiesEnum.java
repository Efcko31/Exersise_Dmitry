package ru.Oop.FightForEnum;

import lombok.Getter;

@Getter
public enum EnemiesEnum {
    SLIME(new Enemy("Кислотный слизень", " растворен в кислоте.", " растворена в кислоте.")),
    GOBLIN(new Enemy("Зеленый гоблин", " изрезан кривым кинжалом.", " изрезана кривым кинжалом.")),
    BASILISK(new Enemy("Василиск", " превращен в камень.", " превращена в камень.")),
    VAMPIRE(new Enemy("Вампир", " был обезкровлен!", " была обезкровлена!")),
    DARK_EXECUTIONER(new Enemy("Темный палач", " обезглавлен.", " обезглавлена."));
    private final Enemy enemy;

    EnemiesEnum(Enemy enemy) {
        this.enemy = enemy;
    }


}
