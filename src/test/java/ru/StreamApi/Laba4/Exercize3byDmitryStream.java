package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercize3byDmitryStream {
    //Дан массив чисел, найти 1-е вхождение числа Х в массив, если нет, то выбросить исключение

    @Test
    void test() {
        assertTrue(lookForNumberXInArray(List.of(1, 2, 3, 4, 5), 4));
        assertThrows(NoSuchElementException.class, () -> lookForNumberXInArray(List.of(1, 3, 4, 5, 6), 2));
    }

    public boolean lookForNumberXInArray(List<Integer> listNumber, int x) throws NoSuchElementException {
        if (listNumber.contains(x)) {
            return true;
        } else {
            throw new NoSuchElementException();
        }
    }
}
