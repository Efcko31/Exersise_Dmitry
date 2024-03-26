package ru.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba6Ex9 {
    //Преобразовать строку таким образом, чтобы после каждого заданного символа c1
    //был вставлен символ c2, если c2 не следует за c1 в исходной строке.
    @Test

    public void test() {
        assertEquals("Жа&ра& на& улице, ну просто пипец!", insertCharacterC1AfterC2ItNotThere(
                "Жара на улице, ну просто пипец!", 'а', '&'));

        assertEquals("А*бра*ка*дра*риба*ра*дуприба*ра*!", insertCharacterC1AfterC2ItNotThere(
                "Абракадрарибарадуприбара!", 'а', '*'));

        assertEquals("Сложение,0 вычитание,0 умножение,0 деление.", insertCharacterC1AfterC2ItNotThere(
                "Сложение, вычитание, умножение, деление.", ',', '0'));

        assertEquals("Сложени|е, вычи|тани|е, умножени|е, делени|е.", insertCharacterC1AfterC2ItNotThere(
                "Сложение, вычитание, умножение, деление.", 'и', '|'));

        assertEquals("Сложение, вычитание, умножение, деление.", insertCharacterC1AfterC2ItNotThere(
                "Сложение, вычитание, умножение, деление.", '*', '|'));

        assertEquals(" ", insertCharacterC1AfterC2ItNotThere(
                " ", ' ', '|'));

    }

    private String insertCharacterC1AfterC2ItNotThere(String string, char symbol1, char symbol2) {
        String[] stringArray = string.split(" ");

        for (int i = 0; i < stringArray.length; i++) {
            string = string.replaceAll(stringArray[i], searchForC1InEveryWord(stringArray[i], symbol1, symbol2));
        }
        return string;
    }

    private String searchForC1InEveryWord(String word, char symbol1, char symbol2) {
        String[] wordArray = word.split("");
        int indexForReplace = 1;
        for (int i = 0; i < wordArray.length; i++) {
            if (i != wordArray.length - 1 && wordArray[i].equalsIgnoreCase(Character.toString(symbol1))) {
                word = insertingCharacter(word, i, indexForReplace, symbol2);
                indexForReplace++;
            } else if (wordArray[i].equalsIgnoreCase(Character.toString(symbol1))) {
                word += symbol2;
            }

        }
        return word;
    }

    private String insertingCharacter(String word, int i, int indexForReplace, char symbol2) {
        StringBuilder stringForInsert = new StringBuilder(word);
        stringForInsert.insert(i + indexForReplace, symbol2);
        word = stringForInsert.toString();
    return word;
    }
}
