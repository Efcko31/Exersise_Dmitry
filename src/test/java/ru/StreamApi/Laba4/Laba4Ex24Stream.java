package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Laba4Ex24Stream {
    //Определить, можно ли, переставив члены данной последовательности, получить геометрическую прогрессию.
    @Test
    void test() {
        assertTrue(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(Arrays.asList(1,3,2,4,6,5,7,8)));
        assertFalse(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(Arrays.asList(1,1,1,1)));
        assertFalse(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(Arrays.asList(1,7,3,2)));
        assertTrue(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(Arrays.asList(2,6,8,4,12,10,14,16)));
        assertFalse(determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(List.of()));
    }

    public boolean determinesWhetherItIsPossibleGetGeometricProgressionFromNumbersInArray(List<Integer> listNumber) {
        List<Integer> listForAnswer = new ArrayList<>(listNumber.stream().toList());
        if(listForAnswer.isEmpty()) return false;
        listForAnswer.sort(Comparator.naturalOrder());

        int diff = listForAnswer.get(1) - listForAnswer.get(0);
//        return listNumber.stream().map((o1, o2) -> o1 - o2).allMatch((o1, o2) -> diff.equals(o1.) ? 0 : 1);
        for (int i = 1; i < listForAnswer.size(); i++) {
            if (listForAnswer.get(i) - listForAnswer.get(i-1) != diff ||
                    listForAnswer.get(i).equals(listForAnswer.get(i - 1))) {
                return false;
            }
        }
        return true;
    }
}
