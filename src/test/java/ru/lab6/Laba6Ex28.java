package ru.lab6;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex28 {
    //Удалить из строки все символы, не являющиеся буквами, а прописные буквы заменить строчными.

    @Test
    public void test() {
        assertEquals("привет как дела", removesCharactersReplacesLowercaseLettersWithUppercaseOnes("Пр№и%вЕт, Ка:К Де)Ла?"));

        assertEquals("правила", removesCharactersReplacesLowercaseLettersWithUppercaseOnes("П5Р:аВ8%и))Л***а"));

        assertEquals("правила апельсин", removesCharactersReplacesLowercaseLettersWithUppercaseOnes("   П5Р:аВ8%и))Л***а   А78%%пель:3син     "));

    }

    private String removesCharactersReplacesLowercaseLettersWithUppercaseOnes(String string) {
        return StringUtils.normalizeSpace(string.replaceAll("[^A-Za-zА-Яа-я ]", "").toLowerCase());//*
    }
}
