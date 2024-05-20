package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Laba7Ex6 {
    //  Определить, является ли данное слово палиндромом.


    @Test
    void test() {
        assertTrue(isWordPalindrome("Аппа"));
        assertTrue(isWordPalindromeByRecursion("Аппа", 0));

        assertFalse(isWordPalindrome("Машина"));
        assertFalse(isWordPalindromeByRecursion("Машина", 0));

        assertTrue(isWordPalindrome("Апокопа"));
        assertTrue(isWordPalindromeByRecursion("Апокопа", 0));

        assertFalse(isWordPalindrome("йцукенгшщапролд"));
        assertFalse(isWordPalindromeByRecursion("йцукенгшщапролд", 0));

        assertTrue(isWordPalindrome(""));
        assertTrue(isWordPalindromeByRecursion("", 0));

    }

    private boolean isWordPalindrome(String sentence) {
        //return sentence.equalsIgnoreCase(StringUtils.reverse(sentence));
        String[] sentenceArray = sentence.toLowerCase().split("");

        for (int i = 0; i < sentenceArray.length; i++) {
            if (!sentenceArray[i].equals(sentenceArray[sentenceArray.length - 1 - i])) {
                return false;
            }
        }

        return true;
    }

    private boolean isWordPalindromeByRecursion(String sentence, int i) {
        String[] sentenceArray = sentence.toLowerCase().split("");

        if (!sentenceArray[i].equals(sentenceArray[sentenceArray.length - 1 - i])) {
            return false;
        }

        i++;

        return i >= sentenceArray.length || isWordPalindromeByRecursion(sentence, i);
    }
}
