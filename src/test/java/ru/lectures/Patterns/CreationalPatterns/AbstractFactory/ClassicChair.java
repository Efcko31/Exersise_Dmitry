package ru.lectures.Patterns.CreationalPatterns.AbstractFactory;

public class ClassicChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Сидеть на классическом стуле");
    }
}
