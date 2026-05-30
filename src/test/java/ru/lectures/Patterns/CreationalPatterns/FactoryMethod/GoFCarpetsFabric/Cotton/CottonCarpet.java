package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Cotton;

import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Carpet;

public class CottonCarpet implements Carpet {
    @Override
    public void createCarpet() {
        System.out.println("Создан хлопковый ковер!");
    }
}
