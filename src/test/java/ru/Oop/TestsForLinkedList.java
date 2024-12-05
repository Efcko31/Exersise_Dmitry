package ru.Oop;

import org.junit.jupiter.api.Test;

public interface TestsForLinkedList<T> {
    @Test
    void checkAdditionAnElementToLinkedListByEfcko();
    T[] addElementsToArray(T[] numbers);
    @Test
    void checkReceiptAnItemFromLinkedList();
    T testGet(T[] numbers, int indexGet);
    @Test
    void checkingReplacementAnItemInLinkedList();
    T[] testSet(T[] numbers, int indexSet, T dataForSet);
    @Test
    void checkingDeletionAnItemFromLinkedList();
    T[] testRemove(T[] numbers, int indexRemove);
    @Test
    void checkingGetIndexAnElement();
    T testIndexOf(T[] numbers, int n);
}
