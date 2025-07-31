package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.NonGoFCarpetsFabric;

public class CarpetFactory {
    public Carpet createCarpet(String type) {
        return switch (type.toLowerCase()) {
            case "synthetic" -> new SyntheticCarpet();
            case "wool" -> new WoolCarpet();
            case "cotton" -> new CottonCarpet();
            default -> throw new IllegalArgumentException("Неизвестный материал: " + type);
        };
    }

}
