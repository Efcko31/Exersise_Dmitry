package ru;

import java.util.ArrayList;
import java.util.List;

public class ForTest {
    static List<int[]> globalList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            globalList.add(new int[1000000]);
            System.out.println("Added" + (i + 1) + " MB to globalList");
            Thread.sleep(1000);
        }

        for (int j = 0; j < 10; j++) {
            int[] temp = new int[1000000];
            System.out.println("Created and abandoned " + (j+1) + " MB");
            Thread.sleep(500);
        }


        System.out.println("Objects in globalList: " + globalList.size());
        System.gc(); // Просим GC поработать
        Thread.sleep(2000);
        System.out.println("After GC. Objects in globalList: " + globalList.size());
    }
}

