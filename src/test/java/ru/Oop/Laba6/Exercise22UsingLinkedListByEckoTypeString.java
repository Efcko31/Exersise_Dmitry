package ru.Oop.Laba6;

import org.junit.jupiter.api.Test;
import ru.DTO.LinkedListByEfckoTypeString;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise22UsingLinkedListByEckoTypeString {
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

        assertEquals("дела?", outputsWordsSentenceInReverseOrderOneAtTime(
                "дела?"));

        assertEquals("", outputsWordsSentenceInReverseOrderOneAtTime(""));
        assertThrows(NullPointerException.class, () -> outputsWordsSentenceInReverseOrderOneAtTime(null));
    }

    private String outputsWordsSentenceInReverseOrderOneAtTime(String sentence) {
        try {
            LinkedListByEfckoTypeString sentenceList = new LinkedListByEfckoTypeString();
            addArrayInLinkedList(sentenceList, sentence.trim().split(" "));

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < sentenceList.size(); i++) {
                answer.append(sentenceList.get(i)).append(" ");
            }

            return answer.toString().trim();
        } catch (NullPointerException e) {
            System.out.println("Строка совсем пуста!");
            throw e;
        }
    }

    public void addArrayInLinkedList(LinkedListByEfckoTypeString stringList, String[] stringArray) {
        for (int i = stringArray.length - 1; i >= 0; i--) {
            stringList.add(stringArray[i]);
        }
    }
}
