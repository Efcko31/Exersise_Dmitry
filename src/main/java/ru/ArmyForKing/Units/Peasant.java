package ru.ArmyForKing.Units;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Peasant peasant = (Peasant) o;
        return age == peasant.age &&
                healthAssessment == peasant.healthAssessment &&
                Objects.equals(firstName, peasant.firstName) &&
                Objects.equals(lastName, peasant.lastName) &&
                Objects.equals(patronymic, peasant.patronymic) && Objects.equals(gender, peasant.gender) && Objects.equals(description, peasant.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, gender, age, healthAssessment, description);
    }
}
