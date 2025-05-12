package ru.lectures.Patterns.CreationalPatterns.AbstractFactory;

public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Сидеть на современном стуле");
    }
}
