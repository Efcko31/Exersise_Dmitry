package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.CarpetFactory;

public class AbstractCarpetFactory {
    public static void main(String[] args) {
        ClassicCarpetFactory classicCarpetFactory = new ClassicCarpetFactory();
        BathroomCarpet classicBathroomCarpet = classicCarpetFactory.createBathroomCarpet();
        LivingRoomCarpet classicLivingRoomCarpet = classicCarpetFactory.createLivingRoomCarpet();
        classicBathroomCarpet.laidInTheBathroom();
        classicLivingRoomCarpet.spreadOutInFrontOfTheSofa();

        ModernCarpetFactory modernCarpetFactory = new ModernCarpetFactory();
        BathroomCarpet modernBathroomCarpet = modernCarpetFactory.createBathroomCarpet();
        LivingRoomCarpet modernLivingRoomCarpet = modernCarpetFactory.createLivingRoomCarpet();
        modernBathroomCarpet.laidInTheBathroom();
        modernLivingRoomCarpet.spreadOutInFrontOfTheSofa();
    }
}
