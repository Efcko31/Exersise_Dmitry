package ru.StreamApi.StreamWithCollectors;

import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExLevel3 {
    //Статистика по словам
    //Вход: List<String> words = List.of("apple", "banana", "apricot", "cherry", "blueberry");
    //Выход: Map<String, IntSummaryStatistics> (ключ — первая буква слова, значение — статистика по длинам слов).
    @Test
    void compilesStatisticsBasedOnWordsTest() {
        compilesStatisticsBasedOnWords(List.of("apple", "banana", "apricot", "cherry", "blueberry"));
    }

    public void compilesStatisticsBasedOnWords(List<String> words) {
        Map<Character, IntSummaryStatistics> answer = words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0),
                        Collectors.summarizingInt(String::length)));
        System.out.println(answer);
    }

    //Разделение людей на группы по возрасту и имени
    //Вход: Та же List<Person> people.
    //Выход: Map<Boolean, Map<Character, List<Person>>> (первый ключ — возраст > 25, второй — первая буква имени).
    @Test
    void dividesPeopleIntoGroupsByAgeAndNameTest() {
        dividesPeopleIntoGroupsByAgeAndName(List.of(
                new PersonForExLevel2("Alice", 25),
                new PersonForExLevel2("Bob", 30),
                new PersonForExLevel2("Charlie", 25)
        ));
    }

    public void dividesPeopleIntoGroupsByAgeAndName(List<PersonForExLevel2> people) {
        Map<Boolean, Map<Character, List<PersonForExLevel2>>> answer = people.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getAge() > 25,
                        Collectors.groupingBy(person -> person.getName().charAt(0))));
        System.out.println(answer);
    }

    //Кастомная свёртка строк
    //Вход: List<String> words = List.of("one", "two", "three");
    //Выход: String (строка вида "1-one, 2-two, 3-three", где числа — порядковые номера слов).
    //Ожидаемый результат: "1-one, 2-two, 3-three"
    @Test
    void convertsWordsToNumbersTest() {
        convertsWordsToNumbers(List.of("one", "two", "three"));
    }

    public void convertsWordsToNumbers(List<String> words) {
        String answer = IntStream.range(0, words.size())
                .mapToObj(i -> (i + 1) + "-" + words.get(i))
                .collect(Collectors.joining(", "));
        System.out.println(answer);
    }
}
