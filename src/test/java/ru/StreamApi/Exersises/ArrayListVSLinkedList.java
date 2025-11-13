package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVSLinkedList {

    @Test
    public void oneMillionElementsForArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000001; i++) {
            arrayList.add(i);
        }
        System.out.println(System.currentTimeMillis() - time);
    }
    @Test
    public void oneMillionElementsForLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000001; i++) {
            linkedList.add(i);
        }
        System.out.println((System.currentTimeMillis() - time));
    }
    //ArrayList ~ 166; LinkedList ~ 87;
}
