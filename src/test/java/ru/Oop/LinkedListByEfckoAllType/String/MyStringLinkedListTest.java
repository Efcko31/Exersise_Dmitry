package ru.Oop.LinkedListByEfckoAllType.String;

import org.junit.jupiter.api.Test;
import ru.Oop.LinkedListByEfckoAllType.Integer.LinkedListByEckoTypeInteger;

public class MyStringLinkedListTest {

    @Test
    void test() {
        LinkedListByEfckoTypeString str1 = new LinkedListByEfckoTypeString();
        str1.add("Привет");
        str1.add("мир");
        str1.add("Салам");
        str1.add("гречка");
        str1.add("234");
        System.out.println(str1.elementByEfcko(3).hasNext());
        print(str1);

        str1.set(2, "Салат");
        str1.add("Салат");
        str1.add("Привет");
        print(str1);

        str1.remove(4);
        str1.remove(12);
        print(str1);

//        System.out.println(str1.indexOf("Салат"));
//        System.out.println(str1.lastIndexOf("Салат"));
//        System.out.println(str1.indexOf("Салат234"));
//        System.out.println(str1.lastIndexOf("3333Салат"));
//        System.out.println(str1.contains("мир"));
//        System.out.println(str1.contains("world"));

    }
    public static void print(LinkedListByEfckoTypeString list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(";\n");
    }
}
