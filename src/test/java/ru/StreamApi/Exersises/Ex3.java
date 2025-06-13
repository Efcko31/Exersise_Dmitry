package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex3 {
    //Дан список объектов Person (с полями name и age).
    // Необходимо найти средний возраст людей, чьи имена начинаются на переданную букву (регистронезависимо).
    @Test
    void test() {
        findTheAverageAgeOfPeopleWhoseNamesBeginWithTheGivenLetter(Arrays.asList(
                new PersonForEx3("Alice", 25), new PersonForEx3("Bob", 30),
                new PersonForEx3("Alex", 20), new PersonForEx3("Anna", 28)
        ), "A");
    }

    public void
    findTheAverageAgeOfPeopleWhoseNamesBeginWithTheGivenLetter(List<PersonForEx3> persons, String letter) {
        System.out.println(persons.stream()
                .filter(n -> letter.equalsIgnoreCase(n.getName().substring(0, 1)))
                .mapToDouble(PersonForEx3::getAge)
                .average().orElse(0.0d));
    }
}
