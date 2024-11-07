package ru.Oop.LinkedListByEfckoAllType;

import org.junit.jupiter.api.Test;

public class LinkedListByEfckoTest {
    @Test
    void test() {
        LinkedListByEfcko<Integer> listTest1 = new LinkedListByEfcko<>();
        listTest1.add(new ElementByEfcko<>(1));
        listTest1.add(new ElementByEfcko<>(null));
        listTest1.add(new ElementByEfcko<>(3));
        LinkedListByEfcko<Integer> listTest2 = new LinkedListByEfcko<>();
        listTest2.add(new ElementByEfcko<>(null));
        listTest2.add(new ElementByEfcko<>(2));
        listTest2.add(new ElementByEfcko<>(3));
        listTest2.add(new ElementByEfcko<>(3));

        System.out.println(listTest1.equals(listTest2));

        System.out.println(listTest2.indexOf(3));
        System.out.println(listTest2.indexOf(1));
        System.out.println(listTest2.indexOf(null));
        System.out.println(listTest2.contains(3));
        System.out.println(listTest2.contains(1));
        System.out.println(listTest2.contains(null));

    }

    public static void print(LinkedListByEfcko<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(";\n");
    }
}
