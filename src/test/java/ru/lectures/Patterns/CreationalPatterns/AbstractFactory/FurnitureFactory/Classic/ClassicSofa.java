package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Classic;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Sofa;

public class ClassicSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Лежать на классическом диване");
    }
}
