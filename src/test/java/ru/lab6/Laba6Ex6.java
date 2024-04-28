package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex6 {
    //Преобразовать строку, заменяя каждое слово «this» словом «the».
    @Test
    public void test() {
        assertEquals("the! is a flower!", replacesThisWithThe("this! is a flower!",
                "this", "the"));

        assertEquals("the the the the the the", replacesThisWithThe("this this this this this this",
                "this", "the"));

        assertEquals("the the the the the the", replacesThisWithThe("this tHiS THIS this tHis thIs",
                "this", "the"));

        assertEquals("It's a beautiful world!", replacesThisWithThe("It's a beautiful world!",
                "this", "the"));

        assertEquals("It's a beautiful catch!", replacesThisWithThe("It's a beautiful world!",
                "world", "catch"));

        assertEquals("", replacesThisWithThe("", "uwu", "rar"));

    }

    private String replacesThisWithThe(String string, String word1, String word2) {
        return string.replaceAll("(?i)" + word1, word2);
    }
}
