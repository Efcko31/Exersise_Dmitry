package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba4Ex3Stream {
    // Если число x встречается в последовательности, то упорядочить по убыванию
    //часть последовательности до последнего вхождения x
    @Test
    void test() {
        assertEquals(List.of(9, 3, 7, 6, 4, 2), sortArrayUpToFirstX(List.of(9, 3, 7, 6, 4, 2), 1));
        assertEquals(List.of(9, 7, 6, 4, 3, 1, 2), sortArrayUpToFirstX(List.of(9, 3, 7, 6, 4, 1, 2), 1));
        assertEquals(List.of(1, 3, 5, 4, 2, 9, 7), sortArrayUpToFirstX(List.of(1, 3, 5, 4, 2, 9, 7), 1));
        assertEquals(List.of(77, 55, 12, 9, 7, 5, 4, 3, 2, 77, 647, 89),
                sortArrayUpToFirstX(List.of(77, 3, 5, 4, 2, 9, 7, 12, 55, 77, 647, 89), 77));
        assertEquals(List.of(), sortArrayUpToFirstX(Collections.emptyList(), 1));
    }

    private List<Integer> sortArrayUpToFirstX(List<Integer> listNumber, int x) {
        if (listNumber.contains(x)) {
//            List<Integer> list = new ArrayList<>(listNumber.stream().
//                    takeWhile(i -> i != x).
//                    sorted(Comparator.reverseOrder()).
//                    toList()); //todo До ПОСЛЕДНЕГО вхождения Х
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < listNumber.lastIndexOf(x); i++) {
                list.add(listNumber.get(i));
            }
            list.sort(Comparator.reverseOrder());

            for (int i = listNumber.lastIndexOf(x); i < listNumber.size(); i++) {
                list.add(listNumber.get(i));
            }
            return list;
        } else {
            return listNumber;
        }
    }

}
