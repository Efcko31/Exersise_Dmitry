package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex28 {
    //Удалить из строки все символы, не являющиеся буквами, а прописные буквы заменить строчными.

    @Test
    public void test() {
        assertEquals("привет как дела", removesCharactersReplacesLowercaseLettersWithUppercaseOnes("Пр№и%вЕт, Ка:К Де)Ла?"));

        assertEquals("правила", removesCharactersReplacesLowercaseLettersWithUppercaseOnes("П5Р:аВ8%и))Л***а"));
    }

    private String removesCharactersReplacesLowercaseLettersWithUppercaseOnes(String string) {
        String[] stringArray = string.split(" ");
        StringBuilder stringToAnswer = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase();
            stringToAnswer.append(stringArray[i]).append(" ");
        }

        return stringToAnswer.toString().trim();
    }
}
