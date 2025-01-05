package ru.Oop.Laba6;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import ru.dto.ElementByEfckoTypeString;
import ru.dto.LinkedListByEfckoTypeString;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise4UsingLinkedListByEckoTypeString {
    //Удалить из данной строки слова, содержащие заданную последовательность символов.
    @Test
    public void test() {
        assertEquals("Мама купила вкусный хлеб", removesWordsContainingCharactersFromCondition(
                "Мама купила очень вкусный хлеб", "ень"));

        assertEquals("Мама купила очень вкусный хлеб", removesWordsContainingCharactersFromCondition(
                "Мама купила очень вкусный хлеб", "жшд"));

        assertEquals("Мы были в большом театре, с большой сценой!", removesWordsContainingCharactersFromCondition(
                "Мы были в очень большом театре, с очень большой сценой!", "оЧе"));

        assertEquals("Кушали мы дома , эти вот были очень !", removesWordsContainingCharactersFromCondition(
                "Кушали мы дома мамины блины, эти вот блины были очень вкусны!", "ны"));

        assertEquals("Мама купила очень вкусный хлеб", removesWordsContainingCharactersFromCondition(
                "Мама купила очень вкусный хлеб", " "));

        assertEquals("", removesWordsContainingCharactersFromCondition(
                "Тыгыдык тыгыдык тыгыдык тыгыдык", "тЫгЫ"));

        assertEquals("Мама купила - вкусный хлеб", removesWordsContainingCharactersFromCondition(
                "Мама купила очень-очень вкусный хлеб", "ень")); // как убрать -
        assertThrows(NullPointerException.class, () -> removesWordsContainingCharactersFromCondition(
                "", ""));
    }

    public static void checkArrayIsEmpty(String str) throws NullPointerException {
        if (str.isEmpty()) {
            throw new NullPointerException("Строка не должена быть пустой!");
        }
    }

    private String removesWordsContainingCharactersFromCondition(String string, String symbols) throws NullPointerException {
        try {
            checkArrayIsEmpty(string);
            LinkedListByEfckoTypeString stringList = new LinkedListByEfckoTypeString();
            addArrayInLinkedList(stringList, string.replaceAll("[^a-zA-Zа-яА-Я]", " ").split(" "));
            String answer = searchWordInList(stringList, symbols.toLowerCase(), string);
            return StringUtils.normalizeSpace(answer);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void addArrayInLinkedList(LinkedListByEfckoTypeString stringList, String[] stringArray) {
        for (String str : stringArray) {
            stringList.add(str);
        }
    }

    public String searchWordInList(LinkedListByEfckoTypeString stringList, String symbols, String string) {
        ElementByEfckoTypeString element = stringList.getHead();
        for (int i = 0; i < stringList.size(); i++) {
            if (element.getData().toLowerCase().contains(symbols)) {
                string = string.replaceAll(element.getData(), "");
            }
            element = element.getNext();
        }
    return string;
    }
}
