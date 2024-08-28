package ru.Oop.AccessLevels.TechnicalDepartment;

import ru.Oop.AccessLevels.Person;
import ru.Oop.AccessLevels.TestAccessLevels;

public class Engineer extends Person {
    public Engineer(String firstName) {
        super(firstName);
    }

    public static void main(String[] args) {
        TestAccessLevels.example11();
        Person.example1();
        Person.example3();
    }
}
