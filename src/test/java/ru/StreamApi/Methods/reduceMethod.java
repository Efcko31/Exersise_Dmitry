package ru.StreamApi.Methods;

import org.junit.jupiter.api.Test;
import ru.StreamApi.StreamWithCollectors.PersonForExLevel2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class reduceMethod {

    //Найти сумму чисел в списке
    @Test
    void findsTheSumOfTheNumbersInTheListTest() {
        assertEquals(15, findsTheSumOfTheNumbersInTheList(List.of(1, 2, 3, 4, 5)));
    }

    public Integer findsTheSumOfTheNumbersInTheList(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    //Найти произведение чисел
    @Test
    void findsTheProductOfNumbersInAListTest() {
        assertEquals(24, findsTheProductOfNumbersInAList(List.of(2, 3, 4)));
    }

    public Integer findsTheProductOfNumbersInAList(List<Integer> numbers) {
        return numbers.stream().reduce((a, b) -> a * b).orElse(-1);
        //return numbers.stream().reduce((a, b) -> a * b); //Optional[result]

    }

    //Объединить строки через запятую
    @Test
    void combinesLinesSeparatedByCommasTest() {
        assertEquals("Java, Kotlin, Python",
                combinesLinesSeparatedByCommas(List.of("Java", "Kotlin", "Python")));
    }

    public String combinesLinesSeparatedByCommas(List<String> words) {
        return words.stream()
                .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b);
    }

    //Найти самого старшего человека в списке.
    @Test
    void findsTheOldestOneTest() {
        assertEquals("PersonForExLevel2(name=Bob, age=30)", findsTheOldestOne(List.of(
                new PersonForExLevel2("Alice", 25),
                new PersonForExLevel2("Bob", 30),
                new PersonForExLevel2("Charlie", 20)
        )));
    }

    public String findsTheOldestOne(List<PersonForExLevel2> people) {
        return people.stream()
                .reduce((a, b) -> a.getAge() > b.getAge() ? a : b)
                .orElse(new PersonForExLevel2("Empty", 0))
                .toString();
    }

    //Найти строку с максимальной длиной, но вернуть её в верхнем регистре.
    @Test
    void findsTheStringWithTheMaximumLengthButReturnItInUppercaseTest() {
        assertEquals("BANANA", findsTheStringWithTheMaximumLengthButReturnItInUppercase(List.of("apple", "banana", "kiwi")));
        assertEquals("EMPTY", findsTheStringWithTheMaximumLengthButReturnItInUppercase(List.of()));
    }

    public String findsTheStringWithTheMaximumLengthButReturnItInUppercase(List<String> words) {
        return words.stream()
                .reduce((a, b) -> a.length() > b.length() ? a : b)
                .orElse("EMPTY").toUpperCase();
    }

    //Дан список чисел. Найти минимальное число
    @Test
    void findsTheMinimumNumberTest() {
        assertEquals(1, findsTheMinimumNumber(List.of(2, 3, 56, 43, 22, 1, 43, 55, 678, 93)));
    }

    public Integer findsTheMinimumNumber(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::min)
                .orElse(-1);
    }

    //Дан список строк. Найти самую короткую строку
    @Test
    void findsTheShortestStringTest() {
        assertEquals(Optional.of("C#"),
                findsTheShortestString(List.of("Java", "Kotlin", "Python", "C#")));
    }

    public Optional<String> findsTheShortestString(List<String> strings) {
        return strings.stream()
                .reduce((a, b) -> a.length() < b.length() ? a : b);
    }

    //Объединить все строки в одну, разделяя их точкой с запятой
    @Test
    void combinesWordsIntoASingleLineSeparatedByASemicolonTest() {
        assertEquals("Java; Kotlin; Python; C#",
                combinesWordsIntoASingleLineSeparatedByASemicolon(List.of("Java", "Kotlin", "Python", "C#")));
    }

    public String combinesWordsIntoASingleLineSeparatedByASemicolon(List<String> words) {
        return words.stream().reduce((a, b) -> a.isEmpty() ? b : a + "; " + b).orElse("EMPTY!");
    }

    //Дан список заказов, где каждый заказ содержит товары и их количество. Нужно:
    //1) Найти общее количество каждого товара (суммировать дубликаты).
    //2) Вернуть результат как Map<String, Integer> (название товара → общее количество).
    @Test
    void findTheTotalQuantityOfEachProductTest() {
        findTheTotalQuantityOfEachProduct(List.of(
                new OrderForReduceMethodExercise("Яблоко", 5),
                new OrderForReduceMethodExercise("Банан", 3),
                new OrderForReduceMethodExercise("Яблоко", 2),
                new OrderForReduceMethodExercise("Груша", 4)
        ));
    }

    public void findTheTotalQuantityOfEachProduct(List<OrderForReduceMethodExercise> orders) {
        Map<String, Integer> answer = orders.stream()
                .collect(Collectors
                        .groupingBy(OrderForReduceMethodExercise::getProductName,
                                Collectors.summingInt(OrderForReduceMethodExercise::getQuantity)));

        Map<String, Integer> totalQuantities = orders.stream()
                .reduce(new HashMap<>(), (map, order) -> {
                    map.merge(order.getProductName(), order.getQuantity(), Integer::sum);
                    return map;
                }, (map1, map2) -> {
                    map2.forEach((k, v) -> map1.merge(k, v, Integer::sum));
                    return map1;
                });
        System.out.println("Простое решение" + answer);
        System.out.println("Решение с reduce:" + totalQuantities);
    }

    //Дан список строк в формате: "a:1", "b:2", "a:3". Посчитай сумму чисел для каждого ключа.
    @Test
    void countsTheSumOfTheNumbersForEachKeyTest() {
        countsTheSumOfTheNumbersForEachKey(List.of("a:1", "b:2", "a:3", "a:1", "b:2", "a:3"));
        countsTheSumOfTheNumbersForEachKey(List.of("a:1", "a:2", "a:3", "a:1", "a:2", "a:3"));
        countsTheSumOfTheNumbersForEachKey(List.of("a:1", "b:2", "c:3", "d:3", "e:3"));
    }

    public void countsTheSumOfTheNumbersForEachKey(List<String> strings) {
        Map<String, Integer> answer = strings.stream().reduce(new HashMap<>(),
                (map, str) -> {
                    map.merge(
                            str.substring(0, str.indexOf(":")),
                            Integer.parseInt(str.substring(str.indexOf(":") + 1)),
                            Integer::sum);
                    return map;
                }
                , (map1, map2) -> {
                    map2.forEach((k, v) -> map1.merge(k, v, Integer::sum));
                    return map1;
                }
                );
        System.out.println(answer);
        System.out.println("____________________________________");
    }

    //Дан список строк, содержащих числа в формате "число:вес" (например, "10:3" — число 10 с весом 3). Нужно:
    //Разбить строки на пары (число, вес).
    //Найти средневзвешенное значение по формуле:
    //средневзвешенное = (число1 * вес1 + число2 * вес2 + ...) / (вес1 + вес2 + ...)
    //Вернуть Optional<Double>, если список не пустой
    @Test
    void findTheWeightedAverageUsingTheFormulaTest() {
        assertEquals(Optional.of(22.0d), findTheWeightedAverageUsingTheFormula(List.of("10:3", "20:2", "30:5")));
    }

    public Optional<Double> findTheWeightedAverageUsingTheFormula(List<String> weightedNumbers) {
        return weightedNumbers.stream()
                .map(s -> s.split(":"))
                .map(arr -> new double[]{
                        Double.parseDouble(arr[0]),
                        Double.parseDouble(arr[1])
                }).reduce((acc, pair) -> new double[]{
                        acc[0] + pair[0] * pair[1],
                        acc[1] + pair[1]
                }).map(acc -> acc[0] / acc[1]);
    }
}
