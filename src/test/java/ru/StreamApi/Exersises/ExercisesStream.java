package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExercisesStream {
    //Найти сумму квадратов всех чётных чисел.
    @Test
    void findsTheSumOfTheSquaresOfAllEvenNumbersTest() {
        assertEquals(56, findsTheSumOfTheSquaresOfAllEvenNumbers(List.of(1, 2, 3, 4, 5, 6)));
    }

    public Integer findsTheSumOfTheSquaresOfAllEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0).map(n -> n * n).reduce(0, Integer::sum);
        //.mapToInt(n -> n * n)
        //.sum();
    }

    // Сгруппировать слова по их длине в Map<Integer, List<String>>
    @Test
    void groupsWordsByTheirLengthTest() {
        groupsWordsByTheirLength(List.of("Java", "Python", "C", "Kotlin", "Scala"));
    }

    public void groupsWordsByTheirLength(List<String> words) {
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
    }

    //Найти самое длинное слово. Если список пуст, вернуть Optional.empty().
    @Test
    void findsTheLongestWordTest() {
        findsTheLongestWord(List.of("apple", "banana", "cherry", "date"));
        findsTheLongestWord(List.of("cherry", "banana", "appple", "date"));
    }

    public void findsTheLongestWord(List<String> words) {
        System.out.println(words.stream()
                .max(Comparator.comparingInt(String::length)));
    }

    //Дан список списков чисел. Объединить все числа в один список и отсортировать по убыванию.
    @Test
    void combinesTheListsIntoOneListAndSortsThemInAscendingOrderTest() {
        assertEquals(List.of(1, 2, 3, 4, 5, 6), combinesTheListsIntoOneListAndSortsThemInAscendingOrder(List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6))));
    }

    public List<Integer> combinesTheListsIntoOneListAndSortsThemInAscendingOrder(List<List<Integer>> nestedNumbers) {
        return nestedNumbers.stream()
                .flatMap(List::stream)
                .sorted()
                .toList();
    }

    //Посчитать, сколько уникальных символов (букв) используется во всех строках.
    @Test
    void countsUniqueLettersAndCharactersInStringsTest() {
        assertEquals(10, countsUniqueLettersAndCharactersInStrings(List.of("hello", "world", "java")));
    }

    public Long countsUniqueLettersAndCharactersInStrings(List<String> words) {
        return words.stream().flatMap(s -> Arrays.stream(s.split(""))).distinct().count();
    }
}
