package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.NonGoFCarpetsFabric;

public class FactoryCarpetTest {
    public static void main(String[] args) {
        CarpetFactory osta = new CarpetFactory();
        Carpet syntheticCarpet = osta.createCarpet("synthetic");
        Carpet woolCarpet = osta.createCarpet("Wool");
        Carpet cottonCarpet = osta.createCarpet("coTtoN");
        //Carpet unknownCarpet = osta.createCarpet("coTt5oN");

        syntheticCarpet.create();
        woolCarpet.create();
        cottonCarpet.create();
        // unknownCarpet.create(); //неизвестный материал
    }
}
