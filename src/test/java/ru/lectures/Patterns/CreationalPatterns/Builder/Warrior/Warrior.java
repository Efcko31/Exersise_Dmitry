package ru.lectures.Patterns.CreationalPatterns.Builder.Warrior;

import lombok.Setter;

@Setter
public class Warrior {
    public String helmet;
    public String armor;
    public String bracer;
    public String leg;
    public String leftHand;
    public String rightHand;

    @Override
    public String toString() {
        return "Helmet: " + helmet + ",\n" +
                "Armor: " + armor + ",\n" +
                "Bracer: " + bracer + ",\n" +
                "Leg: " + leg + ",\n" +
                "LeftHand: " + leftHand + ",\n" +
                "RightHand: " + rightHand + ";";
    }
}
