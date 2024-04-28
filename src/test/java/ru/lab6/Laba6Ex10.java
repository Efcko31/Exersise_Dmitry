package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Laba6Ex10 {
    //Определить, входит ли в данную строку каждая буква данного слова.
    @Test

    public void test() {
        assertTrue(checkingForPresenceLettersFromWordInSentence("Хорошо на свете жить!",
                "рожа"));

        assertTrue(checkingForPresenceLettersFromWordInSentence("жир, БаБы", "жижа"));

        assertFalse(checkingForPresenceLettersFromWordInSentence("жир, БаБу", "жу-Жу жУ-Жуы"));

        assertFalse(checkingForPresenceLettersFromWordInSentence("Машина Форд - лучше " +
                "ДиРижАБАль - АГА!", "жуй"));

        assertTrue(checkingForPresenceLettersFromWordInSentence("Дебыльноё чувство, " +
                        "что как будто могу и хочу сломать свой код и вродё как и знаю где может подвести, но не Фижу",
                "Ёбаный Фонарь"));

        assertTrue(checkingForPresenceLettersFromWordInSentence("Хы - хы, я наше брешь и ЗаСАтаол",
                "Сало"));

    }

    private boolean checkingForPresenceLettersFromWordInSentence(String sentence, String word) {
        String[] wordArray = word.toLowerCase().split("");
        var sentenceOnLowerCase = sentence.toLowerCase();
        for (int i = 0; i < wordArray.length; i++) {
            if (!sentenceOnLowerCase.contains(wordArray[i])) {
                return false;
            }
        }
        return true;
    }
}