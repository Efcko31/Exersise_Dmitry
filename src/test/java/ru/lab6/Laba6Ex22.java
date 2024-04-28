package ru.lab6;
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

    private String[] outputsWordsSentenceInReverseOrderOneAtTime(String sentence) {
        String[] sentenceArray = sentence.split(" ");
        String stringForReverse;
        for (int i = 0; i < sentenceArray.length / 2; i++) {
            stringForReverse = sentenceArray[i];
            sentenceArray[i] = sentenceArray[sentenceArray.length - i - 1];
            sentenceArray[sentenceArray.length - i - 1] = stringForReverse;
        }
        return sentenceArray;
    }
}
