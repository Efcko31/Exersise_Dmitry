package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Modern;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Sofa;

public class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Лежать на современном диване...");
    }
}
