package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Modern;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Chair;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.FurnitureFactory;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Sofa;

public class ModernFactory implements FurnitureFactory {
    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

}
