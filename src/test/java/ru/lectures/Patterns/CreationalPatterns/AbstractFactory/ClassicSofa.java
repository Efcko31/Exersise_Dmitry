package ru.lectures.Patterns.CreationalPatterns.AbstractFactory;

public class ClassicSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Лежать на классическом диване");
    }
}
