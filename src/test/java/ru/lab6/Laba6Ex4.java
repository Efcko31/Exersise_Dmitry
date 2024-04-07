package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex4 {
    //Удалить из данной строки слова, содержащие заданную последовательность символов.

    @Test
    public void test() {
        assertEquals("Мама купила вкусный хлеб", removesWordsContainingCharactersFromCondition(
                "Мама купила очень вкусный хлеб", "ень"));

        assertEquals("Мама купила очень вкусный хлеб", removesWordsContainingCharactersFromCondition(
                "Мама купила очень вкусный хлеб", "жшд"));

        assertEquals("Мы были в большом театре, с большой сценой!", removesWordsContainingCharactersFromCondition(
                "Мы были в очень большом театре, с очень большой сценой!", "оЧе"));

        assertEquals("Кушали мы дома , эти вот были очень !", removesWordsContainingCharactersFromCondition(
                "Кушали мы дома мамины блины, эти вот блины были очень вкусны!", "ны"));

        assertEquals(" ", removesWordsContainingCharactersFromCondition(
                " ", " "));

        assertEquals("Мама купила очень вкусный хлеб", removesWordsContainingCharactersFromCondition(
                "Мама купила очень вкусный хлеб", " "));

        assertEquals(" ", removesWordsContainingCharactersFromCondition(
                "Тыгыдык тыгыдык тыгыдык тыгыдык", "тЫгЫ"));

        assertEquals("Мама купила - вкусный хлеб", removesWordsContainingCharactersFromCondition(
                "Мама купила очень-очень вкусный хлеб", "ень")); // как убрать -
    }

    private String removesWordsContainingCharactersFromCondition(String string, String symbols) {
        String stringWithoutPunctuationMarks = string.replaceAll("[^a-zA-Zа-яА-Я]", " ");
        String[] arrayString = stringWithoutPunctuationMarks.split("\\s+");

        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].toLowerCase().contains(symbols.toLowerCase())) {
                string = string.replaceAll(arrayString[i], "");
                string = string.replaceAll("[\\s]{2,}", " ");
            }
        }
        return string;
    }
}
