package ru.Oop.AccessLevels.TechnicalDepartment;

import ru.Oop.AccessLevels.Person;
import ru.Oop.AccessLevels.TestAccessLevels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    protected String name;

    public static void main(String[] args) {
        TestAccessLevels.example11();
        Person.example1();
    }
}
