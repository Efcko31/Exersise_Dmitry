package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric;

public abstract class Creator {
    public abstract Carpet createSomeCarpet();

    public void create() {
        Carpet carpet = createSomeCarpet();
        carpet.createCarpet();
    }
}
