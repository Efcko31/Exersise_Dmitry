package ru.lectures.Patterns.CreationalPatterns.AbstractFactory;

public class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Лежать на современном диване...");
    }
}
