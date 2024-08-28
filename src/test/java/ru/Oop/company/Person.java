package ru.Oop.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    protected String firstName;
    protected String lastName;
    protected String patronymic;
    protected int age;
    protected LocalDate dateOfBirth;

    @Override
    public String toString() {
        return String.format("Имя: %s\nФамилия: %s\nОтчество: %s\nВозраст: %d\nДата рождения: " + dateOfBirth,
                firstName, lastName, patronymic, age);
    }
}
