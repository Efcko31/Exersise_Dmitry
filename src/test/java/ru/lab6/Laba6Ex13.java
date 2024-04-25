package ru.lab6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex13 {
    //Определить, есть ли в данной строке одинаковые слова и вывести их.
    @Test
    public void test() {
        assertEquals("лев прав", outputIdenticalWordsInSentences
                ("Мама, лев, прав, может быть и праВ, Лев"));

        assertEquals("машина", outputIdenticalWordsInSentences
                ("Авто, автомобиль, автомашина, автозак, маШИна, грузовик и снегоход тоже Машина"));

        assertEquals("машина", outputIdenticalWordsInSentences
                ("маШИна, маШИна, маШИна, маШИна, маШИна, грузовик и маШИна тоже Машина"));

    }

    private String outputIdenticalWordsInSentences(String sentence) {
        String[] sentenceArray = sentence.replaceAll("[^A-Za-zА-Яа-я ]", "").toLowerCase().split(" ");
        Arrays.sort(sentenceArray);
        StringBuilder sentenceForAnswerBuilder = new StringBuilder();

        for (int i = 1; i < sentenceArray.length && !sentenceForAnswerBuilder.toString().contains(sentenceArray[i]); i++) {
            if (sentenceArray[i].equalsIgnoreCase(sentenceArray[i - 1])) {
                sentenceForAnswerBuilder.append(sentenceArray[i] + " ");
            }
        }
        return sentenceForAnswerBuilder.toString().trim();
    }
}