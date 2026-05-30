package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ListSetN1 {
    // Убираем дубликаты из List
    // с помощью Set
    @Test
    public void removingDuplicatesFromListUsingSet() {
        LinkedList<Integer> listNumb = new LinkedList<>();
        listNumb.add(1);
        listNumb.add(2);
        listNumb.add(3);
        listNumb.add(2);

        LinkedList<String> listStr = new LinkedList<>();
        listStr.add("aaa");
        listStr.add("bbb");
        listStr.add("ccc");
        listStr.add("aaa");

        Set<Integer> setListNum = new HashSet<>(listNumb);
        Set<String> setListStr = new HashSet<>(listStr);

        setListNum.forEach(System.out::println);
        setListStr.forEach(System.out::println);

    }
}
