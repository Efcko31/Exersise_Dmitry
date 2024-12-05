package ru;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        print(list);

        list.add(2, 32);
        print(list);
        list.remove(3);
        print(list);

        List<Integer> listForAdd = new ArrayList<>();
        listForAdd.add(11);
        listForAdd.add(22);
        listForAdd.add(33);

        list.addAll(listForAdd);
        print(list);

        ArrayDeque<Integer> a = new ArrayDeque<>();

    }

    public static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(";\n");
    }
}
