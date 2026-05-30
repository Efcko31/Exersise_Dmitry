package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric;

import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Cotton.CottonCarpetCreator;
import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Synthetic.SyntheticCarpetCreator;
import ru.lectures.Patterns.CreationalPatterns.FactoryMethod.GoFCarpetsFabric.Wool.WoolCarpetCreator;

public class FactoryCarpetWithGoFTest {
    public static void main(String[] args) {
        Creator creatorWool = new WoolCarpetCreator();
        creatorWool.create();

        Creator creatorSynthetic = new SyntheticCarpetCreator();
        creatorSynthetic.create();

        Creator creatorCotton = new CottonCarpetCreator();
        creatorCotton.create();
    }
}
