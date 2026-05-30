package ru.Oop.Laba4;

import java.util.ArrayList;

public class Laba4Util {
    public static void addArrayInArrayList(ArrayList<Integer> array, Integer[] numberArray, int exitCondition) {
        for (int i = 0; i < exitCondition; i++) {
            array.add(numberArray[i]);
        }
    }

    public static void checkArrayIsEmpty(Integer[] numbersArray) {
        if (numbersArray.length == 0) {
            throw new NullPointerException("Массив не должен быть пустым!");
        }
    }
}
