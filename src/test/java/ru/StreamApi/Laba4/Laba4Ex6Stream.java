package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Laba4Ex6Stream {
    //Определить, можно ли, переставив члены данной целочисленной последовательности, получить арифметическую прогрессию.
    private static final String NEGATIVE = "НЕТ";
    private static final String POSITIVE = "ДА";

    @Test
    void test() {
        assertTrue(determinesPresenceArithmeticProgression(Arrays.asList(9, 3, 12, 6, 15)));
        assertFalse(determinesPresenceArithmeticProgression(Arrays.asList(9, 3, 7, 6, 4, 2)));
        assertFalse(determinesPresenceArithmeticProgression(Arrays.asList(9, 3, 12, 6, 15, 16)));
        assertTrue(determinesPresenceArithmeticProgression(Arrays.asList(3, 6, 9, 12, 15)));
        assertFalse(determinesPresenceArithmeticProgression(Arrays.asList(1, 2, 3, 4, 15)));
    }

    private boolean determinesPresenceArithmeticProgression(List<Integer> listNumber) {
        List<Integer> list1 = listNumber.stream().sorted(Comparator.reverseOrder()).toList();
        int diff = list1.get(0) - list1.get(1);
        //list1.stream().filter(i, j -> i - j == diff)

        for (int i = 1; i < list1.size(); i++) {
            if (list1.get(i - 1) - list1.get(i) != diff) {
                return false;
            }
        }
    return true;
    }
}
