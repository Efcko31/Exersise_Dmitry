package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.CarpetFactory;

public class ClassicCarpetFactory implements CarpetsFactory {
    @Override
    public BathroomCarpet createBathroomCarpet() {
        return new ClassicStyleBathroomCarpet();
    }

    @Override
    public LivingRoomCarpet createLivingRoomCarpet() {
        return new ClassicStyleLivingRoomCarpet();
    }
}
