package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Ex14 {
    //Найти сумму всех чисел после знака =, игнорируя некорректные значения (например, NaN).
    @Test
    void test() {
        findTheSumOfAllTheNumbersAfterTheSign(Arrays.asList("A=15", "B=20", "C=NaN", "D=10", "E=abc"));
        findTheSumOfAllTheNumbersAfterTheSign(Arrays.asList("A=15", "B=c20", "C=NaN", "D=10", "E=abc"));
    }
    public void findTheSumOfAllTheNumbersAfterTheSign(List<String> pairs) {
        Integer answer = pairs.stream()
                .filter(s -> s.substring(s.indexOf("=") + 1).matches("\\d+"))
                .map(n -> n.substring(n.indexOf("=") + 1))
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(answer);
    }
}
