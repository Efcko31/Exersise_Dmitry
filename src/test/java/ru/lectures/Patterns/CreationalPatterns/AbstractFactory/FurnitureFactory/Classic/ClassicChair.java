package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Classic;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Chair;

public class ClassicChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Сидеть на классическом стуле");
    }
}
