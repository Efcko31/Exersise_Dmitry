package ru.Oop.LinkedListByEfckoAllType.String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStringLinkedListTest {

    @Test
    void test() {
        assertEquals("ТТТ Приветствую тебя на новых голодных играх!",
                testAdd("Приветствую тебя на новых голодных играх!"));

        assertEquals("молоко фасоль;", testGet("молоко банан хлеб фасоль", 0, 3));
        assertEquals("хлеб банан;", testGet("молоко банан хлеб фасоль", 2, 1));
        assertThrows(IndexOutOfBoundsException.class, () ->
                testGet("молоко банан хлеб фасоль", 2, 12));
        assertThrows(IndexOutOfBoundsException.class, () ->
                testGet("молоко банан хлеб фасоль", 2, -22));

        assertEquals("Заменил это: очень, на это: WWW",
                testSet("много очень часто в сайте",1, "WWW"));
        assertEquals("Заменил это: много, на это: GGG",
                testSet("много очень часто в сайте",0, "GGG"));
        assertEquals("Заменил это: сайте, на это: XXX",
                testSet("много очень часто в сайте",4, "XXX"));
        assertThrows(IndexOutOfBoundsException.class, () ->
                testSet("много очень часто в сайте",6, "ZZZ"));
        assertThrows(IndexOutOfBoundsException.class, () ->
                testSet("много очень часто в сайте",-12, "ZZZ"));

        assertEquals("Удалил это: вкусно", testRemove("много мало вкусно надо", 2));
        assertEquals("Удалил это: много", testRemove("много мало вкусно надо", 0));
        assertEquals("Удалил это: надо", testRemove("много мало вкусно надо", 3));
        assertThrows(IndexOutOfBoundsException.class, () -> testRemove("много мало вкусно надо", 12));
        assertThrows(IndexOutOfBoundsException.class, () -> testRemove("много мало вкусно надо", -2));

        assertEquals("Получил индекс слова хлеб: 3",
                testIndexOf("кушай не обляпайся, хлеб очень вкусный", "хлеб"));
        assertEquals("Получил индекс слова хлеб: 0",
                testIndexOf("кушай не обляпайся, хлеб очень вкусный", "кушай"));
        assertEquals("Получил индекс слова хлеб: 5",
                testIndexOf("кушай не обляпайся, хлеб очень вкусный", "вкусный"));
        assertEquals("Получил индекс слова хлеб: -1",
                testIndexOf("кушай не обляпайся, хлеб очень вкусный", "чай"));
    }

    public String testAdd(String string) {
        LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
        stringToList(listStr, string.split(" "));
        listStr.add(0, "ТТТ");
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < listStr.size(); i++) {
            answer.append(listStr.get(i) + " ");
        }

    return answer.toString().trim();
    }

    public String testGet(String string, int index1, int index2) {
        try {LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
        stringToList(listStr, string.split(" "));
        return String.format("%s %s;",listStr.get(index1), listStr.get(index2));
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }

    }

    public String testSet(String string, int setIndex, String replacementString) {
        try {LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
        stringToList(listStr, string.split(" "));
        return String.format("Заменил это: %s, на это: %s",
                listStr.set(setIndex, replacementString),
                listStr.get(setIndex));
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    public String testRemove(String string, int removeIndex) {
        try {
            LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
            stringToList(listStr, string.split(" "));
            return String.format("Удалил это: %s", listStr.remove(removeIndex));
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    public String testIndexOf(String string, String word) {
        LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
        stringToList(listStr, string.split(" "));
        return String.format("Получил индекс слова хлеб: %d", listStr.indexOf(word));
    }

    public void stringToList(LinkedListByEfckoTypeString listStr, String[] strArray) {
        for (String s : strArray) {
            listStr.add(s);
        }
    }

    public static void print(LinkedListByEfckoTypeString list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(";\n");
    }
}
