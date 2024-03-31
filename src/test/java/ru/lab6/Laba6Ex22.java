package ru.lab6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Laba6Ex22 {
    // Вывести слова данной строки в обратном порядке по одному в строке экрана.

    @Test
    public void test() {
        assertArrayEquals(new String[] {"дела?", "как", "Привет,"}, outputsWordsSentenceInReverseOrderOneAtTime(
                "Привет, как дела?"));

        assertArrayEquals(new String[] {"абаба", "Боба", "Ааа"}, outputsWordsSentenceInReverseOrderOneAtTime("Ааа Боба абаба"));

        assertArrayEquals(new String[] {"дела?", "как", "Привет,"}, outputsWordsSentenceInReverseOrderOneAtTime(
                "Привет, как дела?"));
    }

    private String[] outputsWordsSentenceInReverseOrderOneAtTime(String string) {
        String[] stringArray = string.split(" ");
        String[] reverseStringArray = string.split(" ");
        for (int i = stringArray.length - 1; i > -1; i--) {
            reverseStringArray[stringArray.length - i - 1] = stringArray[i];
        }
        return reverseStringArray;
    }
}
