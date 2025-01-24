package ru.StreamApi.Laba4;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba4Ex15Stream {
    //Если в целочисленной последовательности нет других чисел кроме x, y, z, то упорядочить последовательность по убыванию


    @Test
    void test() {
        assertEquals(Arrays.asList(8, 6, 3), CheckingForNumbersAndSorting(Arrays.asList(3, 8, 6), 3, 6, 8));
        assertEquals(Arrays.asList(8, 6, 6, 3, 3), CheckingForNumbersAndSorting(Arrays.asList(3, 3, 8, 6, 6), 3, 6, 8));
        assertEquals(Arrays.asList(3, 8, 6, 4), CheckingForNumbersAndSorting(Arrays.asList(3, 8, 6, 4), 3, 6, 8));
    }

    private List<Integer> CheckingForNumbersAndSorting(List<Integer> listNumber, int x, int y, int z) {
//        List<Integer> list1 = new ArrayList<>();
//        listNumber.stream().filter(i -> i != x && i != y && i != z).forEach(list1::add);


        if (listNumber.stream().allMatch(i -> i == x || i == y || i == z)) {
//            List<Integer> answer = listNumber.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//            listNumber.stream().sorted(Comparator.reverseOrder()).forEach(answer::add);
            return listNumber.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        } else {
            return listNumber;
        }
    }
}
