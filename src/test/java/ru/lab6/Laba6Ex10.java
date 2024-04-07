package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex10 {
    //Определить, входит ли в данную строку каждая буква данного слова.
    private static final String NEGATIVE = "No";

    private static final String POSITIVE = "Yes";

    @Test

    public void test() {
        assertEquals(POSITIVE, checkingForPresenceLettersFromWordInSentence("Хорошо на свете жить!",
                "рожа"));

        assertEquals(POSITIVE, checkingForPresenceLettersFromWordInSentence("жир, БаБы", "жижа"));

        assertEquals(NEGATIVE, checkingForPresenceLettersFromWordInSentence("жир, БаБу", "жу-Жу жУ-Жуы"));

        assertEquals(NEGATIVE, checkingForPresenceLettersFromWordInSentence("Машина Форд - лучше " +
                "ДиРижАБАль - АГА!", "хуй"));

        assertEquals(POSITIVE, checkingForPresenceLettersFromWordInSentence("Дебыльноё чувство, " +
                        "что как будто могу и хочу сломать свой код и вродё как и знаю где может подвести, но не Фижу",
                "Ёбаный Фонарь"));

        assertEquals(POSITIVE, checkingForPresenceLettersFromWordInSentence("Хы - хы, я наше брешь и ЗаСАтаол",
                "Сало"));


    }

    private String checkingForPresenceLettersFromWordInSentence(String string, String word) {
        String[] wordArray = word.split("");
        int matchCounter = 0;

        return checkingLetters(matchCounter, wordArray, string) == wordArray.length ? POSITIVE : NEGATIVE;
    }

    private int checkingLetters(int matchCounter, String[] wordArray, String string) {
        for (int i = 0; i < wordArray.length; i++) {
            if (string.toLowerCase().contains(wordArray[i].toLowerCase())) {
                matchCounter++;
            }
        }
        return matchCounter;
    }
}
