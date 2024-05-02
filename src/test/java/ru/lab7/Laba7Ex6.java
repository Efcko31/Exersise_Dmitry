package ru.lab7;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Laba7Ex6 {
    //  Определить, является ли данное слово палиндромом.


    @Test
    void test() {
        assertTrue(isWordPalindrome("Аппа"));

        assertFalse(isWordPalindrome("Машина"));

        assertTrue(isWordPalindrome("Апокопа"));

        assertFalse(isWordPalindrome("йцукенгшщапролд"));

        assertTrue(isWordPalindrome(""));


        assertTrue(isWordPalindromeByRecursion("Аппа"));

        assertFalse(isWordPalindromeByRecursion("йцукенгшщапролд"));

        assertTrue(isWordPalindromeByRecursion(""));
    }

    private boolean isWordPalindrome(String sentence) {
        StringBuilder sentenceBuilder = new StringBuilder(sentence).reverse();
        return sentenceBuilder.toString().equalsIgnoreCase(sentence);
    }

    private boolean isWordPalindromeByRecursion(String sentence) {
        String[] sentenceArray = sentence.split("");
        StringBuilder sentenceBuilder = new StringBuilder();
        int i = sentenceArray.length - 1;

        return reverseSentence(sentenceArray, sentenceBuilder, i).equalsIgnoreCase(sentence);
    }

    private String reverseSentence(String[] sentenceArray, StringBuilder sentenceBuilder, int i) {
        if (i < 0) {
            return sentenceBuilder.toString();
        }

        sentenceBuilder.append(sentenceArray[i]);
        i--;

        return reverseSentence(sentenceArray, sentenceBuilder, i);
    }

}
