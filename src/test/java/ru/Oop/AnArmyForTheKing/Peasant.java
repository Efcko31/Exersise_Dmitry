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


    public boolean equals(Peasant actual) {
        if (this == null) {
            return actual == null;
        } else if (this.getFirstName().equals(actual.getFirstName()) &&
                this.getLastName().equals(actual.getLastName()) &&
                this.getPatronymic().equals(actual.getPatronymic()) &&
                this.getGender().equals(actual.getGender()) &&
                this.getAge() == actual.getAge() &&
                this.getHealthAssessment() == actual.getHealthAssessment() &&
                this.getDescription().equals(actual.getDescription())) {
            return true;
        } else {
            return false;
        }

    }


}
