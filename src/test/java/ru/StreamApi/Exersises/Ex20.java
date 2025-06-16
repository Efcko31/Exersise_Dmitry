package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex20 {
    //Найти первое число, которое делится на 5 и 3, и вернуть его квадрат.
    @Test
    void test() {
        assertEquals(225,
                findsFirstNumberThatIsDivisible5And3AndReturnsSquare(Arrays.asList("abc", "15", "20", "xyz")));
        assertEquals(-1,
                findsFirstNumberThatIsDivisible5And3AndReturnsSquare(Arrays.asList("abc", "ds", "20", "xyz")));
    }

    public Integer findsFirstNumberThatIsDivisible5And3AndReturnsSquare(List<String> input) {
        return input.stream()
                .flatMap(s -> s.matches("\\d+")
                        ? Stream.of(Integer.parseInt(s))
                        : Stream.empty()).findFirst()
                .filter(n -> n % 5 == 0 & n % 3 == 0)
                .map(n -> n * n)
                .orElse(-1);
    }
}
