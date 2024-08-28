package ru.Oop.company.professions;

import ru.Oop.company.Person;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
public class Driver extends Person {

    protected int drivingExperience;

    public Driver(String firstName,
                  String lastName,
                  String patronymic,
                  int age,
                  LocalDate dateOfBirth,
                  int drivingExperience) {
        super(firstName, lastName, patronymic, age, dateOfBirth);

        this.drivingExperience = drivingExperience;
    }

    @Override
    public String toString() {
        String allInformation = String.format("Имя: %s\nФамилия: %s\nОтчество: %s\nВозраст: %d\nДата рождения: " +
                        dateOfBirth + "\n", firstName, lastName, patronymic, age);

        if (drivingExperience > 4) {
            allInformation += String.format("Стаж вождения: %d лет.\n", drivingExperience);
        } else if(drivingExperience > 1) {
            allInformation += String.format("Стаж вождения: %d года.\n", drivingExperience);
        } else {
            allInformation += String.format("Стаж вождения: %d год.\n", drivingExperience);
        }
    return allInformation;}
}
