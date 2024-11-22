package ru.Oop.LinkedListByEfckoAllType.Integer;

import org.junit.jupiter.api.Test;

public class LinkedListByEckoTypeIntegerTest {
    @Test
    void test() {
        LinkedListByEckoTypeInteger list1 = new LinkedListByEckoTypeInteger();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(2,73);
        print(list1);

        System.out.println(list1.get(4));
        System.out.println(list1.size());
        list1.remove(1);
        print(list1);

        list1.add(5);
        list1.add(4);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        System.out.println(list1.elementByEfcko(2).hasNext());


    }

    public static void print(LinkedListByEckoTypeInteger list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(";\n");
    }
}
