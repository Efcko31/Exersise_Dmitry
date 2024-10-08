package ru.Oop.LinkedListByEfcko;

import org.junit.jupiter.api.Test;

public class LinkedListByEfckoTest {
    @Test
    void test() {
        ListByEfckoTypeInteger listTest = new ListByEfckoTypeInteger();
        listTest.addFront(1);
        listTest.print();
        listTest.deleteElementByValue(1);
        listTest.print();

        listTest.addFront(1);
        listTest.addBack(2);
        listTest.addBack(3);
        listTest.addFront(12);
        listTest.print();

        listTest.deleteElementByValue(3);
        listTest.addFront(7);
        listTest.deleteElementByValue(1);
        listTest.print();


        ListByEfckoAllType listTest2 = new ListByEfckoAllType<>();
        listTest2.addFront(3);
        listTest2.addFront("Пять");
        listTest2.addFront(3.0);
        listTest2.addFront('*');
        listTest2.print();
    }
}
