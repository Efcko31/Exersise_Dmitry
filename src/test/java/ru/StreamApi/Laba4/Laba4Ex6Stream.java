package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Laba4Ex6Stream {
    //Определить, можно ли, переставив члены данной целочисленной последовательности, получить арифметическую прогрессию.
    // Геометрическая - В сколько-то раз

    @Test
    void test() {
        assertTrue(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(List.of(1, 3, 2, 4, 6, 5, 7, 8)));
        assertFalse(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(List.of(1, 1, 1, 1)));
        assertFalse(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(List.of(1, 7, 3, 2)));
        assertTrue(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(List.of(2, 6, 8, 4, 12, 10, 14, 16)));
        assertFalse(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(List.of()));
    }

    public boolean determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(List<Integer> listNumber) {
        List<Integer> listForAnswer = listNumber.stream().
                sorted(Comparator.reverseOrder()).
                toList();
        if (listForAnswer.isEmpty()) return false;

        int diff = listForAnswer.get(1) - listForAnswer.get(0);
//        return listNumber.stream().map((o1, o2) -> o1 - o2).allMatch((o1, o2) -> diff.equals(o1.) ? 0 : 1);
        for (int i = 1; i < listForAnswer.size(); i++) {
            if (listForAnswer.get(i) - listForAnswer.get(i - 1) != diff ||
                    listForAnswer.get(i).equals(listForAnswer.get(i - 1))) {
                return false;
            }
        }
        return true;
    }
}
