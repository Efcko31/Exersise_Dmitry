package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercize2byDmitryStream {
    //Дан массив чисел. Вернуть массив чисел, исключив повторения
    @Test
    void test() {
        assertEquals(List.of(1, 2, 3, 4, 5), returnArrayNumbersWithoutRepeating(List.of(1, 2, 3, 1, 4, 5, 3)));
        assertEquals(List.of(1), returnArrayNumbersWithoutRepeating(List.of(1, 1, 1, 1, 1, 1)));
        assertEquals(List.of(), returnArrayNumbersWithoutRepeating(Collections.emptyList()));
    }

    public List<Integer> returnArrayNumbersWithoutRepeating(List<Integer> numberList) {
        return numberList.stream().
                distinct().
                toList();

    }
}
