package ru.lab6;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Laba6Ex1 {
    //Даны две строки s1 и s2. Пусть w — первое из слов строки s1, которое есть и в строке s2.
    // Найти слово, предшествующее первому вхождению w в s1.
    @Test
    public void test() {
        assertEquals("хорошо", findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1("Они хорошо поели.", "Друзья сходили в кино, а поели - после!"));

        assertNull(findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1("Покушали вкусно, всё понравилось!", "Машина работает очень неплохо!"));

        assertNull(findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1("Хорошо поели", "Оценка за тест - хорошо!"));

        assertNull(findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1(" ", " "));

        assertNull(findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1("", ""));

        assertEquals("Покушали", findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1("Покушали очень вкусно, было очень приятно!",
                "Играл очень долго, игра была очень сложной!"));

        assertNull(findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1("Было очень-очень легко!",
                "Было очень-очень легко!"));

        assertEquals("Было", findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1("Было очень-очень сложно!",
                "Стало очень-очень легко!"));

        assertNull(findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1("Хорошо - хорошо поели", "Оценка за тест - отлично!"));
    }

    private String findWordPrecedingFirstOccurrenceCommonWordS2AndS1InS1(String s1, String s2) { //возвращать boolean

        s1 = s1.replaceAll("[^a-zA-Zа-яА-Я ]", "");
        s2 = s2.replaceAll("[^a-zA-Zа-яА-Я ]", "");
        String[] stringArray = (s1 + " ** " + s2).split("\\s+");
        String wordForAnswer = null;

        return searchForSameWords(stringArray, wordForAnswer);
    }

    private String searchForSameWords(String[] stringArray, String wordForAnswer) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals("**")) {
                return wordForAnswer;
            }
            for (int j = stringArray.length - 1; j != 0 && !stringArray[j].equals("**"); j--) {
                if (i > 0 && stringArray[i].equalsIgnoreCase(stringArray[j])) {
                    wordForAnswer = stringArray[i - 1]; // return wordForAnswer = stringArray[i - 1]; - пишет что never used.
                    i = stringArray.length - 1;
                    j = stringArray.length - 1;
                } else if (i == 0 && stringArray[i].equalsIgnoreCase(stringArray[j])) {
                    i = stringArray.length - 1;
                    j = stringArray.length - 1;
                }
            }
        }
        return wordForAnswer;
    }
}
