package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Classic;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Chair;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.FurnitureFactory;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Sofa;

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
