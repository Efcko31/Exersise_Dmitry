package ru.Oop.AnArmyForTheKing;

import lombok.*;
import lombok.AllArgsConstructor;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Infantryman extends Peasant {
    private String weapon;
    private String armor;

    public Infantryman(String firstName, String lastName, String patronymic, String gender, int age,
                       int healthAssessment, String description, String weapon, String armor ) {
        super(firstName, lastName, patronymic, gender, age, healthAssessment, description);
        this.weapon = weapon;
        this.armor = armor;
    }

}
