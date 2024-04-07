package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex6 {
    //Преобразовать строку, заменяя каждое слово «this» словом «the».
    @Test
    public void test() {
        assertEquals("the! is a flower!", replacesThisWithThe("this! is a flower!"));

        assertEquals("the the the the the the", replacesThisWithThe("this this this this this this"));

        assertEquals("the the the the the the", replacesThisWithThe("this tHiS THIS this tHis thIs"));

        assertEquals("It's a beautiful world!", replacesThisWithThe("It's a beautiful world!"));

        assertEquals(" ", replacesThisWithThe(" "));

    }

    private String replacesThisWithThe(String string) {
        String[] stringArray = string.replaceAll("[^A-Za-zА-Яа-я ]", "").split(" ");

        return checkingEveryWordingSentence(stringArray, string);
    }

    private String checkingEveryWordingSentence(String[] stringArray, String string) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equalsIgnoreCase("this")) {
                string = string.replaceAll(stringArray[i], "the");

            }
        }
    return string;
    }
}
