package ru.lectures.Patterns.CreationalPatterns.AbstractFactory;

public class ClassicFactory implements FurnitureFactory {
    @Override
    public Sofa createSofa() {
        return new ClassicSofa();
    }
    @Override
    public Chair createChair() {
        return new ClassicChair();
    }
}
