package ru.lab6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex22 {
    // Вывести слова данной строки в обратном порядке по одному в строке экрана.

    @Test
    public void test() {
        assertEquals("дела? как Привет,", outputsWordsSentenceInReverseOrderOneAtTime(
                "Привет, как дела?"));

        assertEquals("абаба Боба Ааа", outputsWordsSentenceInReverseOrderOneAtTime("Ааа Боба абаба"));

        assertEquals("дела? как Привет,", outputsWordsSentenceInReverseOrderOneAtTime(
                "Привет, как дела?"));

        assertEquals("настроение? твоё как нового? Что дела? как Привет,",
                outputsWordsSentenceInReverseOrderOneAtTime("Привет, как дела? Что нового? как твоё настроение?"));
    }

    private String outputsWordsSentenceInReverseOrderOneAtTime(String sentence) {
        String[] sentenceArray = sentence.split(" ");
        StringBuilder sentenceReverse = new StringBuilder();

        for (int i = sentenceArray.length - 1; i > -1; i--) {
            sentenceReverse.append(sentenceArray[i] + " ");
        }
        return sentenceReverse.toString().trim();
    }
}
