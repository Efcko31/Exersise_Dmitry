package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Modern;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Chair;

public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Сидеть на современном стуле");
    }
}
