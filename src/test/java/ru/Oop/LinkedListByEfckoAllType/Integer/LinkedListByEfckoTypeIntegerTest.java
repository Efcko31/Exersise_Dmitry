package ru.Oop.LinkedListByEfckoAllType.Integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListByEfckoTypeIntegerTest {
    @Test
    void checkAddAnElementToLinkedListByEfcko() {
        assertArrayEquals(new Integer[]{99, 1, 2, 77, 3, 4, 5}, addElementsToArray(new Integer[]{1, 2, 3, 4, 5}));
    }

    public Integer[] addElementsToArray(Integer[] numbers) {
        LinkedListByEckoTypeInteger list1 = new LinkedListByEckoTypeInteger();
        addList(list1, numbers);
        list1.add(0, 99);
        list1.add(3, 77);

        return toArrayInteger(list1);
    }

    @Test
    void checkReceiptAnItemFromLinkedList() {
        assertEquals(1, testGet(new Integer[]{1, 2, 3, 4, 5}, 0));
        assertEquals(5, testGet(new Integer[]{1, 2, 3, 4, 5}, 4));
        assertEquals(3, testGet(new Integer[]{1, 2, 3, 4, 5}, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> testGet(new Integer[]{1, 2, 3, 4, 5}, 12));
        assertThrows(IndexOutOfBoundsException.class, () -> testGet(new Integer[]{1, 2, 3, 4, 5}, -12));
    }
    public Integer testGet(Integer[] numbers, int indexGet) {
        try {
            LinkedListByEckoTypeInteger list1 = new LinkedListByEckoTypeInteger();
            addList(list1, numbers);
            return list1.get(indexGet);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    @Test
    void checkingReplacementAnItemInLinkedList() {
        assertArrayEquals(new Integer[]{1, 99}, testSet(new Integer[]{1, 2, 3, 4, 5}, 0, 99));
        assertArrayEquals(new Integer[]{2, 676}, testSet(new Integer[]{1, 2, 3, 4, 5}, 1, 676));
        assertArrayEquals(new Integer[]{3, 777}, testSet(new Integer[]{1, 2, 3, 4, 5}, 2, 777));
        assertArrayEquals(new Integer[]{4, 888}, testSet(new Integer[]{1, 2, 3, 4, 5}, 3, 888));
        assertArrayEquals(new Integer[]{5, 102}, testSet(new Integer[]{1, 2, 3, 4, 5}, 4, 102));
        assertThrows(IndexOutOfBoundsException.class, () -> testSet(new Integer[]{1, 2, 3, 4, 5}, 12, 102));
        assertThrows(IndexOutOfBoundsException.class, () -> testSet(new Integer[]{1, 2, 3, 4, 5}, -12, 102));
    }
    public Integer[] testSet(Integer[] numbers, int indexSet, int numberForSet) {
        try {
            LinkedListByEckoTypeInteger list1 = new LinkedListByEckoTypeInteger();
            addList(list1, numbers);

            Integer[] answer = new Integer[2];
            answer[0] = list1.set(indexSet, numberForSet);
            answer[1] = list1.get(indexSet);

            return answer;
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    @Test
    void checkingDeletionAnItemFromLinkedList() {
        assertArrayEquals(new Integer[]{2, 3, 4, 5}, testRemove(new Integer[]{1, 2, 3, 4, 5}, 0));
        assertArrayEquals(new Integer[]{1, 3, 4, 5}, testRemove(new Integer[]{1, 2, 3, 4, 5}, 1));
        assertArrayEquals(new Integer[]{1, 2, 4, 5}, testRemove(new Integer[]{1, 2, 3, 4, 5}, 2));
        assertArrayEquals(new Integer[]{1, 2, 3, 5}, testRemove(new Integer[]{1, 2, 3, 4, 5}, 3));
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, testRemove(new Integer[]{1, 2, 3, 4, 5}, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> testRemove(new Integer[]{1, 2, 3, 4, 5}, -12));
        assertThrows(IndexOutOfBoundsException.class, () -> testRemove(new Integer[]{1, 2, 3, 4, 5}, 12));
    }
    public Integer[] testRemove(Integer[] numbers, int indexRemove) {
        try {
            LinkedListByEckoTypeInteger list1 = new LinkedListByEckoTypeInteger();
            addList(list1, numbers);
            list1.remove(indexRemove);

            return toArrayInteger(list1);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    @Test
    void checkingGetIndexAnElement() {
        assertEquals(0, testIndexOf(new Integer[]{1, 2, 3, 4, 5}, 1));
        assertEquals(1, testIndexOf(new Integer[]{1, 2, 3, 4, 5}, 2));
        assertEquals(2, testIndexOf(new Integer[]{1, 2, 3, 4, 5}, 3));
        assertEquals(3, testIndexOf(new Integer[]{1, 2, 3, 4, 5}, 4));
        assertEquals(4, testIndexOf(new Integer[]{1, 2, 3, 4, 5}, 5));
        assertEquals(-1, testIndexOf(new Integer[]{1, 2, 3, 4, 5}, 44));
        assertEquals(-1, testIndexOf(new Integer[]{1, 2, 3, 4, 5}, -5));
    }
    public Integer testIndexOf(Integer[] numbers, int n) {
        try {
            LinkedListByEckoTypeInteger list1 = new LinkedListByEckoTypeInteger();
            addList(list1, numbers);

            return list1.indexOf(n);
        } catch (IndexOutOfBoundsException e) {
            throw e; // без обработки пробрасываешь наверх рантайм, зачем??? просто лишний код
        }
    }

//    @Test
//    void checkingReceiptAnItemFromLinkedList() {
//        assertArrayEquals(new Integer[]{7, 10, 22, 32, 85, 99},
//                testSortNaturalOrder(new Integer[]{32, 85, 99, 22, 10, 7}));
//        assertArrayEquals(new Integer[]{-7, 0, 10, 22, 32, 85, 99},
//                testSortNaturalOrder(new Integer[]{32, 85, 99, 22, 10, -7, 0}));
//        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5},
//                testSortNaturalOrder(new Integer[]{1, 2, 3, 4, 5}));
//        assertArrayEquals(new Integer[]{},
//                testSortNaturalOrder(new Integer[]{}));
//        assertArrayEquals(new Integer[]{1},
//                testSortNaturalOrder(new Integer[]{1}));
//        assertArrayEquals(new Integer[]{0, 0, 0, 0, 0},
//                testSortNaturalOrder(new Integer[]{0, 0, 0, 0, 0}));
//    }
//    public Integer[] testSortNaturalOrder(Integer[] numbers) {
//        LinkedListByEckoTypeInteger list1 = new LinkedListByEckoTypeInteger();
//        addList(list1, numbers);
//        list1.sortNaturalOrder();
//        return toArrayInteger(list1);
//    }
//
//    @Test
//    void checkingReceiptAnItemFromLinkedList() {
//        assertArrayEquals(new Integer[]{99, 85, 32, 22, 10, 7},
//                testSortReverseOrder(new Integer[]{32, 85, 99, 22, 10, 7}));
//        assertArrayEquals(new Integer[]{99, 85, 32, 22, 10, 0, -7},
//                testSortReverseOrder(new Integer[]{32, 85, 99, 22, 10, -7, 0}));
//        assertArrayEquals(new Integer[]{5, 4, 3, 2, 1},
//                testSortReverseOrder(new Integer[]{5, 4, 3, 2, 1}));
//        assertArrayEquals(new Integer[]{},
//                testSortReverseOrder(new Integer[]{}));
//        assertArrayEquals(new Integer[]{1},
//                testSortReverseOrder(new Integer[]{1}));
//        assertArrayEquals(new Integer[]{0, 0, 0, 0, 0},
//                testSortReverseOrder(new Integer[]{0, 0, 0, 0, 0}));
//    }
//    public Integer[] testSortReverseOrder(Integer[] numbers) {
//        LinkedListByEckoTypeInteger list1 = new LinkedListByEckoTypeInteger();
//        addList(list1, numbers);
//        list1.sortReverseOrder();
//        return toArrayInteger(list1);
//    }

    public Integer[] toArrayInteger(LinkedListByEckoTypeInteger list) {
        Integer[] answer = new Integer[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void addList(LinkedListByEckoTypeInteger list, Integer[] numbers) {
        for (Integer n : numbers) {
            list.add(n);
        }
    }

//    public static void print(LinkedListByEckoTypeInteger list) {
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println(";\n");
//    }
}
