package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Wool;

import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Carpet;

public class WoolCarpet implements Carpet {
    @Override
    public void createCarpet() {
        System.out.println("Создан шерстяной ковер!");
    }
}
