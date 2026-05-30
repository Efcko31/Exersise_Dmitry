package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.CarpetFactory;

public class ModernCarpetFactory implements CarpetsFactory {
    @Override
    public BathroomCarpet createBathroomCarpet() {
        return new ModernStyleBathroomCarpet();
    }

    @Override
    public LivingRoomCarpet createLivingRoomCarpet() {
        return new ModernStyleLivingRoomCarpet();
    }
}
