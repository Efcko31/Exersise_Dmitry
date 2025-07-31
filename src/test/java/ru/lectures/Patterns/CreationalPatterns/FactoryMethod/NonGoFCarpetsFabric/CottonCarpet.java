package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.NonGoFCarpetsFabric;

public class CottonCarpet implements Carpet {
    @Override
    public void create() {
        System.out.println("Создан хлопковый ковер!");
    }
}
