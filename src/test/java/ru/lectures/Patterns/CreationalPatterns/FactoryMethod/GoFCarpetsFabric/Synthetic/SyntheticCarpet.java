package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Synthetic;

import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Carpet;

public class SyntheticCarpet implements Carpet {
    @Override
    public void createCarpet() {
        System.out.println("Создан синтетический ковер!");
    }
}
