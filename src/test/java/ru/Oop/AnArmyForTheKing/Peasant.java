package ru.Oop.AnArmyForTheKing;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Peasant {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String gender;
    private int age;
    private int healthAssessment;
    private String description;
}
