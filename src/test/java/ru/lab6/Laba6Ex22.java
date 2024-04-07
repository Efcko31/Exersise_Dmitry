package ru.lab6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Laba6Ex22 {
    // Вывести слова данной строки в обратном порядке по одному в строке экрана.

    @Test
    public void test() {
        assertArrayEquals(new String[]{"дела?", "как", "Привет,"}, outputsWordsSentenceInReverseOrderOneAtTime(
                "Привет, как дела?"));

        assertArrayEquals(new String[]{"абаба", "Боба", "Ааа"}, outputsWordsSentenceInReverseOrderOneAtTime("Ааа Боба абаба"));

        assertArrayEquals(new String[]{"дела?", "как", "Привет,"}, outputsWordsSentenceInReverseOrderOneAtTime(
                "Привет, как дела?"));

        assertArrayEquals(new String[]{"настроение?", "твоё", "как", "нового?", "Что", "дела?", "как", "Привет,"},
                outputsWordsSentenceInReverseOrderOneAtTime("Привет, как дела? Что нового? как твоё настроение?"));
    }

    private String[] outputsWordsSentenceInReverseOrderOneAtTime(String string) {
        String[] stringArray = string.split(" ");
        String stringForReverse;
        for (int i = 0; i < stringArray.length / 2; i++) {
            stringForReverse = stringArray[i];
            stringArray[i] = stringArray[stringArray.length - i - 1];
            stringArray[stringArray.length - i - 1] = stringForReverse;
        }
        return stringArray;
    }
}
