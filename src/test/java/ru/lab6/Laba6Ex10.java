package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Laba6Ex10 {
    //Определить, входит ли в данную строку каждая буква данного слова.
    @Test

    public void test() {
        assertTrue(checkingForPresenceLettersFromWordInSentence("Хорошо на свете жить!",
                "жаро"));

        assertTrue(checkingForPresenceLettersFromWordInSentence("жир, аоБы", "жижа"));

        assertFalse(checkingForPresenceLettersFromWordInSentence("жир, БаБуин", "жу-Жу жУ-Жуы"));

        assertFalse(checkingForPresenceLettersFromWordInSentence("Машина Форд - лучше " +
                "ДиРижАБАль - машиНа!", "вой"));

        assertTrue(checkingForPresenceLettersFromWordInSentence("Странное чувство, " +
                        "что как будто могу и хочу сломать свой код и вродё как и знаю где может подвести, но не Фижу",
                "Аптека Фонарь"));

        assertTrue(checkingForPresenceLettersFromWordInSentence(" Хе-хе, я нашелс брешь и залотал ее",
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