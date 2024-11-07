package ru.SomeTasks;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ExOfCodeWars1 {
    /*вернуть массив чисел с заданным МАКСИМАЛЬНЫМ количеством повторений чисел в массиве*/

    @Test
    void test() {
        assertArrayEquals(new int[]{1, 1, 3, 3, 7, 2, 2, 2},
                integerArray(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3));

        assertArrayEquals(new int[]{20, 37, 21},
                integerArray(new int[] { 20, 37, 20, 21 }, 1));

        assertArrayEquals(new int[]{ 1, 1, 3, 3, 7, 2, 2, 2 },
                integerArray(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3));

        assertArrayEquals(new int[]{1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5},
                integerArray(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3));

        assertArrayEquals(new int[]{},
                integerArray(new int[]{2, 1, 2, 4, 4 }, 0));
    }

    public static int[] integerArray(int[] elements, int maxOccurrences) {

        if (maxOccurrences != 0) {
            ArrayList<Integer> array = new ArrayList();
            countsNumberRepetitions(elements, array, maxOccurrences);
            print(array);
            return answer(array);
        } else {
            return new int[]{};
        }
    }

    public static void countsNumberRepetitions(int[] elements, ArrayList<Integer> array, int maxOccurrences) {
        ArrayList<Integer> totalElements = new ArrayList();
        for (int i = 0; i < elements.length; i++) {
            if (!array.contains(elements[i])) {
                totalElements.add(elements[i]);
                totalElements.add(1);
                array.add(elements[i]);
            } else {
                if (totalElements.get(searchElem(totalElements, elements[i]) + 1) >= maxOccurrences) {
                } else {
                    array.add(elements[i]);
                    totalElements.set(searchElem(totalElements, elements[i]) + 1, totalElements.get(searchElem(totalElements, elements[i]) + 1) + 1);
                }
            }
        }
    }

    public static int[] answer(ArrayList<Integer> array) {
        int[] answer = new int[array.size()];

        for (int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i);
        }
        return answer;
    }

    public static int searchElem(ArrayList<Integer> totalElements, int number) {
        for (int i = 0; i < totalElements.size(); i += 2) {
            if (number == totalElements.get(i)) {
                return i;
            }
        }
        return 0;
    }

    public static void print(ArrayList<Integer> array) {
        for (int k : array) {
            System.out.print(k + " ");
        }
        System.out.println("\n");
    }
}
