package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex1 {
//Дан список строк. Необходимо отфильтровать строки, длина которых больше 3 символов,
// преобразовать их в верхний регистр и вывести в отсортированном порядке.

    @Test
    void returnsStringsWithMoreThanThreeUppercaseCharactersTest() {
        assertEquals(List.of("JAVA", "JAVASCRIPT", "PYTHON"), returnsStringsWithMoreThanThreeUppercaseCharacters(
                Arrays.asList("Java", "Python", "C", "JavaScript", "Go")));
    }

    public List<String> returnsStringsWithMoreThanThreeUppercaseCharacters(List<String> strings) {

        return strings.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .toList();
    }

}
