package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex14 {
    //Даны две строки. Определить последнее из слов первой строки, которое есть во
    //второй строке.

    @Test
    public void test() {
        assertEquals("хлеб", searchForLastWordFirstLineInSecondLine("страница хлеб везде", "всюду ХлеБ и мрак"));

        assertEquals("Нет слова", searchForLastWordFirstLineInSecondLine("Поезд - поезд и пол",
                "Пазик - пазик и лава"));

        assertEquals("пол", searchForLastWordFirstLineInSecondLine("лава-ЛаВа-пол", "лава-лава-пОл"));

    }

    private String searchForLastWordFirstLineInSecondLine(String firstString, String secondString) {
        String[] firstStringArray = firstString.replaceAll("[^A-Za-zА-Яа-я]", " ").split(" ");
        String lastWord = "Нет слова";

        return comparingWordSentences(firstStringArray, lastWord, secondString);
    }

    private String comparingWordSentences(String[] firstStringArray, String lastWord, String secondString) {
        for (int i = firstStringArray.length - 1; i > -1 && firstStringArray[i].split("").length > 1; i--) {
            if (secondString.toLowerCase().contains(firstStringArray[i].toLowerCase())) {
                lastWord = firstStringArray[i];
                return lastWord;
            }

        }
        return lastWord;
    }
}
