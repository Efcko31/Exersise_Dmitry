package ru.lab6;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex11 {
    // Преобразовать строку таким образом, чтобы цифры каждого слова были перенесены
    //в начало слова и изменить порядок следования цифр в слове на обратный.
    //StringUtils + реегулчрныее выражения
    @Test
    public void test() {
        assertEquals("1раз, 2два, 3три", moveNumbersBeginningLineInReverseOrder(
                "раз1, два2, три3"));

        assertEquals("9874436пвыолашшриольшлтлдь", moveNumbersBeginningLineInReverseOrder(
                "пвыола6шш34рио4льш7лтл8дь9"));

        assertEquals("Предложение без чисел", moveNumbersBeginningLineInReverseOrder(
                "Предложение без чисел"));

        assertEquals("3218Одни 4 98765числа", moveNumbersBeginningLineInReverseOrder(
                "8О1д2н3и 4 ч5и6с7л8а9"));

        assertEquals("8ил", moveNumbersBeginningLineInReverseOrder(
                " и8л "));

        assertEquals("", moveNumbersBeginningLineInReverseOrder(
                ""));

    }

    private String moveNumbersBeginningLineInReverseOrder(String sentence) {
        String[] sentenceArray = sentence.split(" ");
        StringBuilder sentenceBuilder = new StringBuilder();
        for (int i = 0; i < sentenceArray.length; i++) {
            sentenceBuilder.append(new StringBuilder(StringUtils.getDigits(sentenceArray[i])).reverse()).
                    append(sentenceArray[i].replaceAll("[\\d]", "")).append(" ");
        }
        return StringUtils.normalizeSpace(sentenceBuilder.toString());
    }
}