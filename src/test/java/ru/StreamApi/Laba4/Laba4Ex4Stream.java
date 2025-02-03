package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba4Ex4Stream {
    //Дана последовательность целых чисел, содержащая как положительные, так и отрицательные элементы. Упорядочить п
    // оследовательность следующим образом: сначала идут отрицательные числа, упорядоченные по невозрастанию, потом положительные,
    // упорядоченные по неубыванию.
    // Сначала сортировать числа отрицательные, затем, начиная с последнего вхождения отричательного числа - отсортировать положительные.
    @Test
    void test() {
        assertEquals(List.of(-7, -9, 2, 3, 4, 5, 6),
                sortNegativeDescendingOrderAndPositiveAscendingOrder(Arrays.asList(3, -9, 5, -7, 2, 4, 6)));
        assertEquals(List.of(-9, 2, 3, 4, 6, 7),
                sortNegativeDescendingOrderAndPositiveAscendingOrder(Arrays.asList(-9, 3, 7, 6, 4, 2)));
        assertEquals(List.of(-3, -4, -6, -7, -9, 2),
                sortNegativeDescendingOrderAndPositiveAscendingOrder(Arrays.asList(-9, -3, -7, -6, -4, 2)));
        assertEquals(List.of(2, 3, 4, 6, 7, 9),
                sortNegativeDescendingOrderAndPositiveAscendingOrder(Arrays.asList(9, 3, 7, 6, 4, 2)));
        assertEquals(List.of(-6, -7, -8, -9, 1, 2, 3, 4, 5),
                sortNegativeDescendingOrderAndPositiveAscendingOrder(Arrays.asList(1, -8, 4, -6, 5, -9, 3, 2, -7)));
    }

    private List<Integer> sortNegativeDescendingOrderAndPositiveAscendingOrder(List<Integer> listNumber) {
        ArrayList<Integer> listAnswer = new ArrayList<>();
        listNumber.stream().filter(i -> i < 0).sorted(Comparator.reverseOrder()).forEach(listAnswer::add);
        listNumber.stream().filter(i -> i >= 0).sorted(Comparator.naturalOrder()).forEach(listAnswer::add);

        return listAnswer;
    }
}
