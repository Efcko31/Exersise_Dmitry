package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory;

import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Classic.ClassicFactory;
import ru.lectures.Patterns.CreationalPatterns.AbstractFactory.FurnitureFactory.Modern.ModernFactory;

public class AbstractFactory {
    // Создать семейства связанных объектов (например, мебель в одном стиле: «классика», «модерн»).
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFactory();
        Sofa modernSofa = modernFactory.createSofa();
        Chair modernChair = modernFactory.createChair();
        modernSofa.lieOn();
        modernChair.sitOn();

        FurnitureFactory classicFactory = new ClassicFactory();
        Sofa classicSofa = classicFactory.createSofa();
        Chair classicChair = classicFactory.createChair();
        classicSofa.lieOn();
        classicChair.sitOn();
    }
}
