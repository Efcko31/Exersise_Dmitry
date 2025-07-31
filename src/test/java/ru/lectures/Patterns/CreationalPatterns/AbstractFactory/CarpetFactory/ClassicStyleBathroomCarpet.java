package ru.lectures.Patterns.CreationalPatterns.AbstractFactory.CarpetFactory;

public class ClassicStyleBathroomCarpet implements BathroomCarpet {
    @Override
    public void laidInTheBathroom() {
        System.out.println("В ванную постелен коврик в классическом стиле");
    }

}
