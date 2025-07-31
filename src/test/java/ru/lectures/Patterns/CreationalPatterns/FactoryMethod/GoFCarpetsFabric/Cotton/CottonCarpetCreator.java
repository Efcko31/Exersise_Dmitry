package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Cotton;

import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Carpet;
import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Creator;

public class CottonCarpetCreator extends Creator {
    @Override
    public Carpet createSomeCarpet() {
        System.out.println("Запустили станок хлопковых ковров....");
        return new CottonCarpet();
    }
}
