package ru.LinkedListByEfckoAllType.interfac;

import org.junit.jupiter.api.Test;
import ru.myLinkedList.myLinkedListGeneric.LinkedListByEfckoTypeImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTypeIntegerTest {

    @Test
    void checkAddAnElementToLinkedListByEfcko() {
        assertArrayEquals(new Integer[]{99, 1, 2, 77, 3, 4, 5}, addElementsToArray(new Integer[]{1, 2, 3, 4, 5}));
    }

    public Integer[] addElementsToArray(Integer[] numbers) {
        LinkedListByEfckoTypeImpl<Integer> list1 = new LinkedListByEfckoTypeImpl<>();
        addList(list1, numbers);
        list1.add(0, 99);
        list1.add(3, 77);

        return toArrayInteger(list1);
    }

    @Test
    void checkReceiptAnItemFromLinkedList() {
        assertEquals(1, getAnItemFromList(new Integer[]{1, 2, 3, 4, 5}, 0));
        assertEquals(5, getAnItemFromList(new Integer[]{1, 2, 3, 4, 5}, 4));
        assertEquals(3, getAnItemFromList(new Integer[]{1, 2, 3, 4, 5}, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> getAnItemFromList(new Integer[]{1, 2, 3, 4, 5}, 12));
        assertThrows(IndexOutOfBoundsException.class, () -> getAnItemFromList(new Integer[]{1, 2, 3, 4, 5}, -12));
    }
    public Integer getAnItemFromList(Integer[] numbers, int indexGet) throws RuntimeException{

        LinkedListByEfckoTypeImpl<Integer> list1 = new LinkedListByEfckoTypeImpl<>();
        addList(list1, numbers);
        return list1.get(indexGet);
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
            LinkedListByEfckoTypeImpl<Integer> list1 = new LinkedListByEfckoTypeImpl<>();
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
            LinkedListByEfckoTypeImpl<Integer> list1 = new LinkedListByEfckoTypeImpl<>();
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
    public Integer testIndexOf(Integer[] numbers, int n) throws RuntimeException{

        LinkedListByEfckoTypeImpl<Integer> list1 = new LinkedListByEfckoTypeImpl<>();
        addList(list1, numbers);

        return list1.indexOf(n);

    }

    public Integer[] toArrayInteger(LinkedListByEfckoTypeImpl<Integer> list) {
        Integer[] answer = new Integer[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void addList(LinkedListByEfckoTypeImpl<Integer> list, Integer[] numbers) {
        for (Integer n : numbers) {
            list.add(n);
        }
    }
}
