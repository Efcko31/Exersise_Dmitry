package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Wool;

import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Carpet;
import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Creator;

public class WoolCarpetCreator extends Creator {
    @Override
    public Carpet createSomeCarpet() {
        System.out.println("Запустили станок шерстяных ковров....");
        return new WoolCarpet();
    }
}
