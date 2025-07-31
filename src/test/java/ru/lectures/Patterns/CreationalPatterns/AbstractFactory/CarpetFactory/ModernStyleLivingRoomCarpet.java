package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.CarpetFactory;

public class ModernStyleLivingRoomCarpet implements LivingRoomCarpet {
    @Override
    public void spreadOutInFrontOfTheSofa() {
        System.out.println("В гостинной постелен ковер в соверменном стиле");
    }
}
