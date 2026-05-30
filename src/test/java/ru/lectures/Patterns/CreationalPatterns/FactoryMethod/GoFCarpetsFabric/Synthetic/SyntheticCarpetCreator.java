package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Synthetic;

import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Carpet;
import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Creator;

public class SyntheticCarpetCreator extends Creator {
    @Override
    public Carpet createSomeCarpet() {
        System.out.println("Запустили станок синтетических ковров....");
        return new SyntheticCarpet();
    }
}
