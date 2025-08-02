package ru.lectures.Patterns.CreationalPatterns.Singleton.President;

public class Singleton { //Одиночка - гарантирует что класс имеет только 1 экземпляр
    public static void main(String[] args) {
        President president1 = President.getInstance();
        President president2 = President.getInstance();
        System.out.println(president1 == president2); //один и тот же объект

        /*  Проблемы Singleton:
            — Потокобезопасность (решается через synchronized или enum).
            — Тестирование (синглтон может хранить состояние между тестами).*/
    }
}
