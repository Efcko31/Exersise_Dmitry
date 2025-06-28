package ru.StreamApi.StreamWithCollectors;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExLevel2 {
    //Группировка людей по возрасту
    //Выход: Map<Integer, List<String>> (ключ — возраст, значение — список имён).
    @Test
    void groupingPeopleByAgeTest() {
        groupingPeopleByAge(List.of(
                new PersonForExLevel2("Alice", 25),
                new PersonForExLevel2("Bob", 30),
                new PersonForExLevel2("Charlie", 25)));
    }

    public void groupingPeopleByAge(List<PersonForExLevel2> people) {
        Map<Integer, List<String>> answer = people.stream()
                .collect(Collectors.groupingBy(
                                PersonForExLevel2::getAge,
                                Collectors.mapping(
                                        PersonForExLevel2::getName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println(answer);

    }

    //Самый частый возраст
    //Вход: Та же List<Person> people.
    //Выход: Optional<Integer> (возраст, который встречается чаще всего).
    @Test
    void findsTheMostFrequentAgeTest() {
        findsTheMostFrequentAge(List.of(
                new PersonForExLevel2("Alice", 25),
                new PersonForExLevel2("Bob", 30),
                new PersonForExLevel2("Charlie", 25)
        ));
    }

    public void findsTheMostFrequentAge(List<PersonForExLevel2> people) {
        System.out.println(people.stream()
                .collect(Collectors.groupingBy(
                        PersonForExLevel2::getAge,
                        Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey));
    }

    //Сумма возрастов по первой букве имени
    //Вход: Та же List<Person> people.
    //Выход: Map<Character, Integer> (ключ — первая буква имени, значение — сумма возрастов).
    //Ожидаемый результат: {'A'=25, 'B'=30, 'C'=25}
    @Test
    void countsTheSumOfAgesByTheFirstLetterOfTheNameTest() {
        countsTheSumOfAgesByTheFirstLetterOfTheName(List.of(
                new PersonForExLevel2("Alice", 25),
                new PersonForExLevel2("Bob", 30),
                new PersonForExLevel2("Charlie", 25),
                new PersonForExLevel2("Alla", 12),
                new PersonForExLevel2("Barbara", 36),
                new PersonForExLevel2("Charfhj", 20)
        ));
    }

    public void countsTheSumOfAgesByTheFirstLetterOfTheName(List<PersonForExLevel2> people) {
        Map<Character, Integer> answer = people.stream()
                .collect(Collectors.groupingBy(PersonForExLevel2 -> PersonForExLevel2.getName().charAt(0),
                        Collectors.summingInt(PersonForExLevel2::getAge)));
        System.out.println(answer);
    }
}
