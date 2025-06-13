package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex19 {
    //Найти максимальное нечётное число после = или вернуть -1.
    @Test
    void test() {
        assertEquals(5, findTheMaximumOddNumberAfterEquals(List.of("n=5", "x=10", "y=abc")));
        assertEquals(-1, findTheMaximumOddNumberAfterEquals(List.of("n=2", "x=10", "y=abc")));
        assertEquals(-1, findTheMaximumOddNumberAfterEquals(List.of("n=ddd", "x=qwe", "y=abc")));
    }

    public Integer findTheMaximumOddNumberAfterEquals(List<String> numbers) {
        Integer answer = numbers.stream()
                .flatMap(s -> s.substring(s.indexOf('=') + 1)
                        .matches("\\d+")
                        ? Stream.of(Integer.parseInt(s.substring(s.indexOf('=') + 1)))
                        : Stream.empty())
                .filter(n -> n % 2 != 0)
                .max(Integer::compare)
                .orElse(-1);
        return answer;
    }
}
