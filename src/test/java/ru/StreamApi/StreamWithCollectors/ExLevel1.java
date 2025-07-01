package ru.StreamApi.StreamWithCollectors;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExLevel1 {
    //Подсчёт букв в словах
    //Вход: List<String> words = List.of("apple", "banana", "cherry");
    //Выход: Map<Integer, Long> (ключ — длина слова, значение — количество слов такой длины).
    //Ожидаемый результат: {5=1, 6=2}
    @Test
    void countingLettersInWordsTest() {
        //assertEquals(5, countingLettersInWords(List.of("apple", "banana", "cherry")));
        countingLettersInWords(List.of("apple", "banana", "cherry"));
        countingLettersInWords(List.of("apple", "banana", "cherry", "app", "cher", "ban", "ana", "", " ", ">"));
    }

    public void countingLettersInWords(List<String> words) {
        Map<Integer, Long> answer = words.stream()
                .collect(Collectors.groupingBy(
                        String::length, Collectors.counting()));
        System.out.println(answer);
    }

    //Разделение чисел на чётные и нечётные
    //Вход: List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    //Выход: Map<Boolean, List<Integer>> (ключ — true для чётных, false для нечётных).
    //Ожидаемый результат: {false=[1, 3, 5], true=[2, 4, 6]}
    @Test
    void dividesWordsIntoEvenAndOddOnesTest() {
        dividesWordsIntoEvenAndOddOnes(List.of(1, 2, 3, 4, 5, 6));
    }

    public void dividesWordsIntoEvenAndOddOnes(List<Integer> numbers) {
        Map<Boolean, List<Integer>> answer = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println(answer);
    }

    // Объединение строк через разделитель
    //Вход: List<String> names = List.of("Alice", "Bob", "Charlie");
    //Выход: String (имена, соединённые через " и ").
    //Ожидаемый результат: "Alice и Bob и Charlie"
    @Test
    void combinesWordsIntoAStringTest() {
        combinesWordsIntoAString(List.of("Alice", "Bob", "Charlie"));
    }

    public void combinesWordsIntoAString(List<String> names) {
        String answer = names.stream().collect(Collectors.joining(" и "));
        System.out.println(answer);
    }
}
