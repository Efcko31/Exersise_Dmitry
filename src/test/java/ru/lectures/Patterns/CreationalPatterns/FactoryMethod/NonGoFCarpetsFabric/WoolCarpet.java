package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.NonGoFCarpetsFabric;

public class WoolCarpet implements Carpet {
    @Override
    public void create() {
        System.out.println("Создан шерстяной ковер!");
    }
}
