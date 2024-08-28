package ru.Oop.AccessLevels;

import ru.Oop.AccessLevels.TechnicalDepartment.Dog;
import ru.Oop.AccessLevels.TechnicalDepartment.Engineer;
import org.junit.jupiter.api.Test;

public class TestAccessLevels {
    Cat cat1 = new Cat("Кися");
    Dog dog1 = new Dog("Пес");
    Engineer person1 = new Engineer("Василий");
    Seller person2 = new Seller("Анна");

    @Test
    public void test() {
        Person.example1();
        Person.example3();

        Person.example1();
        Person.example2();
        Person.example3();

    }

    public static void example11() {
        System.out.println("Example 11");
    }
    static void example12() {
        System.out.println("Example 12");
    }
    protected static void example13() {
        System.out.println("Example 13");
    }
    private static void example14() {
        System.out.println("Example 14");
    }
}
