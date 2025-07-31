package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.CarpetFactory;

public interface CarpetsFactory {
    BathroomCarpet createBathroomCarpet();
    LivingRoomCarpet createLivingRoomCarpet();
}
