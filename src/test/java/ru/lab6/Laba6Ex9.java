package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex9 {
    //Преобразовать строку таким образом, чтобы после каждого заданного символа c1
    //был вставлен символ c2, если c2 не следует за c1 в исходной строке.
    @Test
    public void test() {
        assertEquals("Жа&ра& на& улице, ну просто ужа&с!", insertCharacterC1AfterC2ItNotThere(
                "Жара& на улице, ну просто ужас!", "а", "&"));

        assertEquals("А*бра*ка*дра*риба*ра*дуприба*ра*!", insertCharacterC1AfterC2ItNotThere(
                "Абракадрарибарадуприбара!", "а", "*"));

        assertEquals("Сложение,0 вычитание,0 умножение,0 деление,0", insertCharacterC1AfterC2ItNotThere(
                "Сложение, вычитание, умножение, деление,", ",", "0"));

        assertEquals("Сложени|е, вычи|тани|е, умножени|е, делени|е.", insertCharacterC1AfterC2ItNotThere(
                "Сложение, вычитание, умножение, деление.", "и", "|"));

        assertEquals("Сложение, вычитание, умножение, деление.", insertCharacterC1AfterC2ItNotThere(
                "Сложение, вычитание, умножение, деление.", "*", "|"));

        assertEquals(" | |", insertCharacterC1AfterC2ItNotThere(
                "  ", " ", "|"));

    }

    private String insertCharacterC1AfterC2ItNotThere(String string, String symbol1, String symbol2) {
        String[] stringArray = string.split("");
        for (int i = 0; i < stringArray.length; i++) {
            if (isSearchedSymbol(symbol1, symbol2, stringArray, i)) {
                stringArray[i] += symbol2;
            }
        }
        return String.join("", stringArray);
    }

    private static boolean isSearchedSymbol(String symbol1, String symbol2, String[] stringArray, int i) {
        return stringArray[i].equalsIgnoreCase(symbol1)
                && (i == stringArray.length - 1 || !stringArray[i + 1].equals(symbol2));
    }
}


/* A & B & C
a = 0
B = 1 
C = 1
*/