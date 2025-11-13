package ru;

import ru.Oop.company.vehicles.Car;

import javax.inject.Named;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Named
public class Test {
    public static void main(String[] args) throws Exception {

        List<PersonForTest> testList = new ArrayList<>();
        testList.add(new PersonForTest("Антон", 20));
        testList.add(new PersonForTest("Иван", 9));
        testList.add(new PersonForTest("Петр", 15));

        System.out.println(testList);

        testList.stream()
                .filter(p -> p.getAge() > 10)
                .peek(p -> p.setName("Изм" + p.getName())
                )
                .toList();
    }
}

