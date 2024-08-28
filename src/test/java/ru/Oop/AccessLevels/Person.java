package ru.Oop.AccessLevels;

import ru.Oop.AccessLevels.TechnicalDepartment.Dog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    protected String firstName;

    public static void example1() {
        System.out.println("Example 1");
    }
    static void example2() {
        System.out.println("Example 2");
    }
    protected static void example3() {
        System.out.println("Example 3");
    }
    private static void example4() {
        System.out.println("Example 4");
    }

    public static void main(String[] args) {
        Person person = new Person("Иван");
        Cat cat2 = new Cat("Кися2");
        Dog dog2 = new Dog("Песя2");

        example1();
        example2();
        example3();
        example4();

        TestAccessLevels.example11();
        TestAccessLevels.example12();
        TestAccessLevels.example13();

    }


}
