package ru.StreamApi.Methods;

import org.junit.jupiter.api.Test;
import ru.StreamApi.StreamWithCollectors.PersonForExLevel2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class sortMethod {
    //Отсортировать список чисел по возрастанию.
    @Test
    void countsTheSumOfTheNumbersForEachKeyTest() {
        assertEquals(List.of(1, 2, 3, 4, 5, 6), countsTheSumOfTheNumbersForEachKey(List.of(5, 2, 3, 1, 6, 4)));
    }

    public List<Integer> countsTheSumOfTheNumbersForEachKey(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    //Отсортировать список чисел по убыванию.
    @Test
    void sortsTheListInDescendingOrderTest() {
        assertEquals(List.of(6, 5, 4, 3, 2, 1), sortsTheListInDescendingOrder(List.of(5, 2, 3, 1, 6, 4)));
    }

    public List<Integer> sortsTheListInDescendingOrder(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    //Сортирует строки по длине от самой короткой до самой длинной.
    @Test
    void sortsStringsByLengthFromShortestToLongestTest() {
        assertEquals(List.of("C", "Java", "Python", "Kotlin"),
                sortsStringsByLengthFromShortestToLongest(List.of("Java", "Python", "C", "Kotlin")));
    }

    public List<String> sortsStringsByLengthFromShortestToLongest(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //Отсортировать список строк по последней букве в алфавитном порядке.
    @Test
    void sortsTheListOfStringsByTheLastLetterTest() {
        sortsTheListOfStringsByTheLastLetter(List.of("banana", "apple", "cherry", "date"));
    }

    public void sortsTheListOfStringsByTheLastLetter(List<String> words) {
        List<String> answer = words.stream()
                .sorted(Comparator.comparingInt((String s) -> s.charAt(s.length() - 1)))
                .toList();
        answer.forEach(s -> System.out.print(s + " "));
    }

    //Отсортировать список людей сначала по возрасту, а при одинаковом возрасте — по имени.
    @Test
    void sortsTheListOfPeopleByAgeTest() {
        assertEquals("Babetta", sortsTheListOfPeopleByAge(List.of(
                new PersonForExLevel2("Alice", 25),
                new PersonForExLevel2("Bob", 20),
                new PersonForExLevel2("Charlie", 25),
                new PersonForExLevel2("Babetta", 20),
                new PersonForExLevel2("Barbara", 23),
                new PersonForExLevel2("Clara", 25)
        )).getFirst().getName());
    }

    public List<PersonForExLevel2> sortsTheListOfPeopleByAge(List<PersonForExLevel2> persons) {
        List<PersonForExLevel2> answer = persons.stream()
                .sorted(Comparator.comparingInt(PersonForExLevel2::getAge)
                        .thenComparing(PersonForExLevel2::getName))
                .toList();

        answer.forEach(s -> System.out.println("Name: " + s.getName() + "; Age: " + s.getAge()));
        return answer;
    }

    //Отсортировать список строк по правилам:
    //Сначала строки, начинающиеся на "A". Затем строки длиной 3. Остальные — в обычном порядке.
    @Test
    void complexCustomSortingWithPrioritiesTest() {
        complexCustomSortingWithPriorities(List.of("Apple", "Banana", "Cat", "Ant", "Dog"));
    }

    public void complexCustomSortingWithPriorities(List<String> items) {
        List<String> answer = items.stream()
                .sorted((s1, s2) -> {
                    if (s1.startsWith("A") && !s2.startsWith("A")) return -1;
                    if (!s1.startsWith("A") && s2.startsWith("A")) return 1;
                    if (s1.length() == 3 && s2.length() != 3) return -1;
                    if (s1.length() != 3 && s2.length() == 3) return 1;
                    return s1.compareTo(s2);
                }).toList();
        List<String> answer2 = items.stream()
                .sorted(Comparator.comparing((String s) -> !s.startsWith("A"))
                        .thenComparing(s -> s.length() != 3)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
        answer.forEach(System.out::println);
        System.out.println("_____________________________________");
        answer2.forEach(System.out::println);
    }

    //Отсортировать список, содержащий null, чтобы null были в конце.
    @Test
    void sortsNullToTheEndOfTheListTest() {
        List<String> result = sortsNullToTheEndOfTheList(
                Arrays.asList("Java", null, "Python", null, "C"));
        assertEquals("C", result.get(0));
        assertFalse(result.isEmpty());
    }

    public List<String> sortsNullToTheEndOfTheList(List<String> listWithNulls) {
        List<String> answer = listWithNulls.stream()
                .sorted(Comparator.nullsLast(Comparator.naturalOrder()))
                .toList();
        answer.forEach(System.out::println);
        return answer;
    }

    //Отсортируй список строк сначала по последней букве, затем по длине.
    @Test
    void sortsTheListOfStringsFirstByTheLastLetterThenByLengthTest() {
        sortsTheListOfStringsFirstByTheLastLetterThenByLength(
                List.of("Apple", "Banana", "Cat", "Ant", "Dog"));
    }

    public List<String> sortsTheListOfStringsFirstByTheLastLetterThenByLength(List<String> str) {
        List<String> answer = str.stream()
                .sorted(Comparator
                        .comparingInt((String s) -> s.charAt(s.length() - 1))
                        .thenComparing(String::length))
                .toList();
        answer.forEach(System.out::println);
        return answer;
    }

    //Отсортируй список чисел, чтобы чётные были перед нечётными
    @Test
    void sortsTheListOfNumbersSoThatTheEvenOnesAreBeforeTheOddOnesTest() {
        sortsTheListOfNumbersSoThatTheEvenOnesAreBeforeTheOddOnes(List.of(1, 6, 2, 5, 3, 4));
    }

    public void sortsTheListOfNumbersSoThatTheEvenOnesAreBeforeTheOddOnes(List<Integer> numbers) {
        List<Integer> answer = numbers.stream()
                .sorted(Comparator
                        .comparing((Integer i) -> i % 2 != 0)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
        answer.forEach(n -> System.out.print(n + " "));
    }

    //Отсортировать список строк так, чтобы:
    //Строки, содержащие "Java", шли первыми. Затем строки длиной > 5. Остальные — в обратном алфавитном порядке.
    @Test
    void complexCustomSortingWithPrioritiesN2Test() {
        assertEquals(List.of("JavaScript", "Java", "Kotlin", "Python", "C++", "Ruby"), complexCustomSortingWithPrioritiesN2(
                List.of("Kotlin", "Java", "Python", "JavaScript", "C++", "Ruby")));
    }

    public List<String> complexCustomSortingWithPrioritiesN2(List<String> words) {
        List<String> answer = words.stream()
                .sorted(Comparator.comparing((String s) -> !s.contains("Java"))
                        .thenComparing(s -> s.length() < 5)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
        return answer;
    }

    //Отсортировать список Person по имени, но если имя null — поместить объект в конец.
    @Test
    void sortsTheListByNamesEmptyAtTheEndOfTheListTest() {
        sortsTheListByNamesEmptyAtTheEndOfTheList(Arrays.asList(
                new PersonForExLevel2("Alice", 25),
                new PersonForExLevel2(null, 30),
                new PersonForExLevel2("Bob", 20),
                new PersonForExLevel2(null, 40)
        ));
    }

    public void sortsTheListByNamesEmptyAtTheEndOfTheList(List<PersonForExLevel2> peoples) {
        List<PersonForExLevel2> answer = peoples.stream()
                .sorted(Comparator
                        .comparing(
                                PersonForExLevel2::getName,
                                Comparator.nullsLast(Comparator.naturalOrder())))
                .toList();
        answer.forEach(p -> System.out.println(p.getName()));
    }

    //Отсортировать список чисел так, чтобы:
    //Чётные числа шли перед нечётными. Чётные сортируются по возрастанию. Нечётные — по убыванию.
    @Test
    void complexCustomSortingWithPriorities3Test() {
        complexCustomSortingWithPriorities3(List.of(5, 2, 9, 1, 6, 4));
    }

    public void complexCustomSortingWithPriorities3(List<Integer> numbers) {
        Comparator<Integer> customComparator = Comparator
                .comparing((Integer i) -> i % 2 != 0)
                .thenComparing(i -> i % 2 == 0 ? i : -i);

        List<Integer> answer = numbers.stream()
                .sorted(customComparator)
                .toList();
        answer.forEach(System.out::println);
    }

    //Отсортировать список строк, игнорируя регистр, но null должны быть в начале.
    @Test
    void sortsTheListMovesNullToTheBeginningTest() {
        sortsTheListMovesNullToTheBeginning(Arrays.asList("apple", null, "Banana", "cherry", null, "Apricot"));
    }

    public void sortsTheListMovesNullToTheBeginning(List<String> words) {

        List<String> answer = words.stream()
                .sorted(Comparator
                        .comparing(
                                s -> s != null ? s.toLowerCase() : s,
                                Comparator.nullsFirst(Comparator.naturalOrder())
                        )
                )
                .toList();
        answer.forEach(System.out::println);
    }

    //Отсортировать список в порядке, заданном другим списком
    @Test
    void sortsTheListInTheOrderSpecifiedByTheOtherListTest() {
        sortsTheListInTheOrderSpecifiedByTheOtherList(List.of("High", "Medium", "Low"), List.of("Low", "High", "Medium", "High", "Low"));
        sortsTheListInTheOrderSpecifiedByTheOtherList(List.of("High", "Medium", "Low"), List.of("Twin", "High", "Medium", "Gorod", "Low"));
        sortsTheListInTheOrderSpecifiedByTheOtherList(List.of("Twin", "Gorod", "Lefortovo"), List.of("Low", "High", "Medium", "High", "Low"));
        sortsTheListInTheOrderSpecifiedByTheOtherList(List.of(2, 1, 3), List.of(2, 2, 3, 3, 1, 1));
    }

    public void sortsTheListInTheOrderSpecifiedByTheOtherList(List<?> order, List<?> priorities) {
        priorities.stream()
                .sorted(Comparator.comparing(order::indexOf))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    //Отсортируй список строк, чтобы строки с буквой "e" шли первыми, а остальные — по убыванию длины.
    @Test
    void sortsTheListOfStringsSoThatTheStringsWithTheLetterGoFirstAndTheRestInDescendingOrderOfLengthTest() {
        sortsTheListOfStringsSoThatTheStringsWithTheLetterGoFirstAndTheRestInDescendingOrderOfLength(
                List.of("Ёжик", "Карамель", "Хлеб", "Зуд", "Ёрш"), "Ё");
    }

    public void sortsTheListOfStringsSoThatTheStringsWithTheLetterGoFirstAndTheRestInDescendingOrderOfLength
            (List<String> words, String letter) {
        List<String> answer = words.stream()
                .sorted(Comparator
                        .comparing((String s) -> s.substring(0, 1).equalsIgnoreCase(letter))
                        .thenComparing(String::length).reversed())
                .toList();
        answer.forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    //Отсортируй список чисел, чтобы простые числа были первыми (простые — это 2, 3, 5, 7, ...).
    @Test
    void sortsTheListOfNumbersSoThatThePrimesComeFirstTest() {
        sortsTheListOfNumbersSoThatThePrimesComeFirst(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12));
    }

    public void sortsTheListOfNumbersSoThatThePrimesComeFirst(List<Integer> numbers) {
        List<Integer> answer = numbers.stream()
                .sorted(Comparator.comparing((Integer n) -> !isPrime(n))
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
        answer.forEach(s -> System.out.print(s + " "));
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Отсортировать числа по возрастанию количества делителей (например, у 6 делители: 1, 2, 3, 6 → 4 шт.)
    @Test
    void sortsNumbersInAscendingOrderOfTheNumberOfDivisorsTest() {
        sortsNumbersInAscendingOrderOfTheNumberOfDivisors(List.of(10, 7, 12, 4));
    }

    public void sortsNumbersInAscendingOrderOfTheNumberOfDivisors(List<Integer> numbers) {

        List<Integer> answer = numbers.stream()
                .sorted()
                .toList();
    }
    public int countsTheNumberOfDivisors(int n){
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }
}
