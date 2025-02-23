package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Laba4Ex24Stream {
    //Определить, можно ли, переставив члены данной последовательности, получить геометрическую прогрессию.


    @Test
    void test() {
        assertTrue(determinesPresenceArithmeticProgression(List.of(2, 4, 8, 32, 16)));
        assertFalse(determinesPresenceArithmeticProgression(List.of(3, 12, 35, 7)));
        assertFalse(determinesPresenceArithmeticProgression(List.of(9, 3, 12, 6, 15, 16)));
        assertTrue(determinesPresenceArithmeticProgression(List.of(4, 1, 64, 16)));
        assertTrue(determinesPresenceArithmeticProgression(List.of(9, 27, 3, 81)));
        assertFalse(determinesPresenceArithmeticProgression(List.of()));
    }

    private boolean determinesPresenceArithmeticProgression(List<Integer> listNumber) {
        List<Integer> list1 = listNumber.stream().
                sorted(Comparator.reverseOrder()).
                toList();
        if (list1.isEmpty()) return false;
        int diff = list1.get(0) / list1.get(1);

        for (int i = 1; i < list1.size(); i++) {
            if (list1.get(i - 1) / list1.get(i) != diff) {
                return false;
            }
        }
        return true;
    }
}
