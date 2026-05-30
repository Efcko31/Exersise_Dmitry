package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.NonGoFCarpetsFabric;

public class SyntheticCarpet implements Carpet {
    @Override
    public void create() {
        System.out.println("Создан синтетический ковер!");
    }
}
