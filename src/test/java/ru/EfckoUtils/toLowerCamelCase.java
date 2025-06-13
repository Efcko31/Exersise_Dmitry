package ru.EfckoUtils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class toLowerCamelCase {
    @Test
    void test() {
        toLowerCamelCaseTest("checks that the string length is more than five characters");
    }
    public void toLowerCamelCaseTest(String sentence) {

        List<String> str = Arrays.stream(sentence.split("[\\s\\p{Punct}]+")).toList();
        String answer =  str.stream().map(word -> word.isEmpty() ? word :
                word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(""));

        // Первое слово должно остаться с маленькой буквы
        if (!answer.isEmpty()) {
            answer = answer.substring(0, 1).toLowerCase() + answer.substring(1);
        }
        System.out.println(answer);
    }
}
