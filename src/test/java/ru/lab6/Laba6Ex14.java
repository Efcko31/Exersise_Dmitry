package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex14 {
    //Даны две строки. Определить последнее из слов первой строки, которое есть во
    //второй строке.

    @Test
    public void test() {
        assertEquals("жопа", searchForLastWordFirstLineInSecondLine("полная жопа везде", "всюду ЖопА и мрак"));

        assertEquals("Нет слова", searchForLastWordFirstLineInSecondLine("Поезд - поезд и пол",
                "Пазик - пазик и лава"));

        assertEquals("пол", searchForLastWordFirstLineInSecondLine("жопа-ЖоПа-пол", "жопа-жопа-пОл"));

    }

    private String searchForLastWordFirstLineInSecondLine(String firstString, String secondString) {
        String[] firstStringArray = firstString.replaceAll("[^A-Za-zА-Яа-я]", " ").split(" ");
        String[] secondStringArray = secondString.replaceAll("[^A-Za-zа-яА-Я]", " ").split(" ");
        String lastWord = "Нет слова";


    return comparingWordSentences(firstStringArray, secondStringArray, lastWord);
    }

    private String comparingWordSentences(String[] firstStringArray, String[] secondStringArray, String lastWord) {
        for (int i = 0; i < firstStringArray.length && firstStringArray[i].split("").length > 1; i++) {
            for ( int j = 0; j < secondStringArray.length; j++) {
                if (firstStringArray[i].equalsIgnoreCase(secondStringArray[j])) {
                    lastWord = firstStringArray[i];
                }
            }
        }
    return  lastWord;
    }
}
