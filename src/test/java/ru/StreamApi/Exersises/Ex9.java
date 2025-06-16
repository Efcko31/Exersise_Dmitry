package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Ex9 {
    //Дан список строк, которые могут содержать числа.
    // Нужно найти первое число, которое делится на 3,
    // преобразовать его в строку и вернуть в верхнем регистре.
    // Если таких чисел нет — вернуть "NOT FOUND".

    @Test
    void test() {
        findsTheFirstMultipleThreeAndTheSumODigitsNumberAndReturnsItInAnUppercaseString(
                Arrays.asList("abc", "12", "45", "xyz", "7", "18"));
        findsTheFirstMultipleThreeAndTheSumODigitsNumberAndReturnsItInAnUppercaseString(
                Arrays.asList("abc", "11", "45", "xyz", "7", "18"));
        findsTheFirstMultipleThreeAndTheSumODigitsNumberAndReturnsItInAnUppercaseString(
                Arrays.asList("abc", "11", "46", "xyz", "7", "18"));
    }

    public void findsTheFirstMultipleThreeAndTheSumODigitsNumberAndReturnsItInAnUppercaseString(List<String> mixedData) {
        String answer = mixedData.stream()
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .map(Object::toString)
                .orElse("NOT FOUND");

        System.out.println(answer);
    }
}
