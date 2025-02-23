package ru.Oop.AnArmyForTheKing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Archer extends Peasant {
    private String weapon;
    private String armor;

    public Archer(String firstName, String lastName, String patronymic, String gender, int age,
                  int healthAssessment, String description, String weapon, String armor) {
        super(firstName, lastName, patronymic, gender, age, healthAssessment, description);
        this.weapon = weapon;
        this.armor = armor;
    }
}
