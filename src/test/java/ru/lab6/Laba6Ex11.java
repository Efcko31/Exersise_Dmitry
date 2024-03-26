package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex11 {
    // Преобразовать строку таким образом, чтобы цифры каждого слова были перенесены
    //в начало слова и изменить порядок следования цифр в слове на обратный.
    @Test
    public void test(){
        assertEquals("1раз, 2два, 3три", moveNumbersBeginningLineInReverseOrder(
                "раз1, два2, три3"));

        assertEquals("9874436пвыолашшриольшлтлдь", moveNumbersBeginningLineInReverseOrder(
                "пвыола6шш34рио4льш7лтл8дь9"));

        assertEquals("Предложение без чисел", moveNumbersBeginningLineInReverseOrder(
                "Предложение без чисел"));

        assertEquals("3218Одни 4 98765числа", moveNumbersBeginningLineInReverseOrder(
                "8О1д2н3и 4 ч5и6с7л8а9"));

        assertEquals(" 8ил ", moveNumbersBeginningLineInReverseOrder(
                " и8л "));

        assertEquals("", moveNumbersBeginningLineInReverseOrder(
                ""));

    }

    private String moveNumbersBeginningLineInReverseOrder(String string){
        String[] stringArray = string.replaceAll("[^A-Za-zА-Яа-я0-9]", " ").split(" ");

        string = goThroughWords(stringArray, string);
    return string;
    }

    private String goThroughWords(String[] stringArray, String string) {
        for (int i = 0; i < stringArray.length; i++) {
            StringBuilder wordForMove = new StringBuilder(stringArray[i]);
            string = string.replaceAll(stringArray[i], moveNumbersBeginningWord(stringArray[i], wordForMove));
        }
    return string;
    }

    private String moveNumbersBeginningWord(String word, StringBuilder wordForMove) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (Character.isDigit(wordArray[i])) {
                wordForMove.deleteCharAt(i);
                wordForMove.insert(0, wordArray[i]);
            }
        }
        word = wordForMove.toString();
    return word;
    }
}
