package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex23_1 {

    //Отсортировать список строк по их длине.
    @Test
    void sortsStringsByLengthTest() {
        assertEquals(List.of("C", "Go", "Java", "Python", "JavaScript"),
                sortsStringsByLength(Arrays.asList("Java", "Python", "C", "JavaScript", "Go")));

    }

    public List<String> sortsStringsByLength(List<String> strings) {

        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    //Отсортировать список строк лексикографически
    @Test
    void sortsTheListOfLexicographicTest() {
        assertEquals(List.of("C", "C++", "Go", "Java", "JavaScript", "Python"),
                sortsTheListOfLexicographic(Arrays.asList("Java", "Python", "C", "JavaScript", "Go", "C++")));
    }

    public List<String> sortsTheListOfLexicographic(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    //Сгруппировать строки по их длине
    @Test
    void groupsStringsByLengthTest() {
        groupsStringsByLength(Arrays.asList("A", "Python", "C", "Mython", "Go", "C#"));
    }

    public void groupsStringsByLength(List<String> strings) {
        System.out.println(strings.stream().collect(Collectors.groupingBy(String::length)));
    }

    //Найти самую длинную строку в списке
    @Test
    void findsTheLongestLineInTheListTest() {
        assertEquals("JavaScript",
                findsTheLongestLineInTheList(Arrays.asList("Java", "Python", "C", "JavaScript", "Go", "C++")));
    }

    public String findsTheLongestLineInTheList(List<String> strings) {

        return strings.stream().max(Comparator.comparing(String::length)).get();
    }

    //Разделить числа на четные и нечетные
    @Test
    void dividesNumbersIntoEvenAndOddOnesTest() {
//        assertEquals(List.of(1,2,3,4,5,6,7),
//                dividesNumbersIntoEvenAndOddOnes(Arrays.asList(1,2,3,4,5,6,7)));
        dividesNumbersIntoEvenAndOddOnes(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    public void dividesNumbersIntoEvenAndOddOnes(List<Integer> numbers) {
        Map<String, List<Integer>> answer = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0))
                .entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey()
                        ? "Четные" : "Нечетные",
                        Map.Entry::getValue));
        System.out.println(answer);
    }

    //Подсчитать сумму длин всех строк в списке
    @Test
    void countsTheSumOfTheLengthsOfAllTheRowsInTheListTest() {
        assertEquals(26, countsTheSumOfTheLengthsOfAllTheRowsInTheList(
                Arrays.asList("Java", "Python", "C", "JavaScript", "Go", "C++")));
    }

    public Integer countsTheSumOfTheLengthsOfAllTheRowsInTheList(List<String> strings) {
        return strings.stream().mapToInt(String::length).sum();
    }

    //Преобразовать список строк в Map, где ключ - строка, значение - её длина.
    @Test
    void countsTheLengthOfEachLineTest() {
        countsTheLengthOfEachLine(Arrays.asList("Java", "Python", "C", "JavaScript", "Go", "C++"));
    }

    public void countsTheLengthOfEachLine(List<String> strings) {
        System.out.println(strings.stream()
                .collect(Collectors.toMap(s -> s, String::length)));
    }

    //Объединить все строки в списке через запятую
    @Test
    void combinesAllLinesInTheListSeparatedByCommasTest() {
        assertEquals("Java, Python, C, JavaScript, Go, C++", combinesAllLinesInTheListSeparatedByCommas(
                Arrays.asList("Java", "Python", "C", "JavaScript", "Go", "C++")));
    }

    public String combinesAllLinesInTheListSeparatedByCommas(List<String> strings) {
        return strings.stream().collect(Collectors.joining(", "));
    }

    //Найти среднюю длину строк в списке
    @Test
    void findsTheAverageLengthOfTheRowsInTheListTest() {
        assertEquals(7.0, findsTheAverageLengthOfTheRowsInTheList(
                Arrays.asList("Javaaaa", "Pythonc", "Ccccccc")));
    }

    public Double findsTheAverageLengthOfTheRowsInTheList(List<String> strings) {
        return strings.stream().mapToInt(String::length).average().orElse(-1.0);
    }

    //Отсортировать список объектов по возрастанию возраста.
    @Test
    void sortsTheListOfObjectsByIncreasingAgeTest() {
        sortsTheListOfObjectsByIncreasingAge(Arrays.asList(
                new PersonForEx3("Alice", 25), new PersonForEx3("Bob", 30),
                new PersonForEx3("Alex", 20), new PersonForEx3("Anna", 28)
        ));
    }

    public void sortsTheListOfObjectsByIncreasingAge(List<PersonForEx3> persons) {
        System.out.println(persons.stream().sorted(Comparator.comparing(PersonForEx3::getAge)).toList());
    }

    //Сортирует
    @Test
    void sortsTheListOfPersonObjectsByAgeDescendingAndIfTheAgesAreEqualByNameTest() {
        sortsTheListOfPersonObjectsByAgeDescendingAndIfTheAgesAreEqualByName(Arrays.asList(
                new PersonForEx3("Blice", 30), new PersonForEx3("Bob", 30),
                new PersonForEx3("Alex", 20), new PersonForEx3("Anna", 28)
        ));
    }

    public void sortsTheListOfPersonObjectsByAgeDescendingAndIfTheAgesAreEqualByName(List<PersonForEx3> persons) {
        List<PersonForEx3> answer = persons.stream()
                .sorted(Comparator.comparingInt(PersonForEx3::getAge)
                        .reversed()
                        .thenComparing(PersonForEx3::getName))
                .toList();
        answer.forEach(p -> System.out.println(p.getName() + ": " + p.getAge()));
    }

    //Сгруппировать список людей по городу проживания
}
