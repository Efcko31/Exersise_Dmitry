package ru.LinkedListByEfckoAllType.String;

import org.junit.jupiter.api.Test;
import ru.MyLinkedList.LinkedListByEfckoTypeString;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStringLinkedListTest {

    @Test
    void checkAddAnElementToLinkedListByEfckoTypeImpl() {
        assertEquals("ТТТ Приветствую тебя ТТТ на новых голодных играх!",
                addElementsToArray("Приветствую тебя на новых голодных играх!"));
    }

    public String addElementsToArray(String string) {
        LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
        stringToList(listStr, string.split(" "));
        listStr.add(0, "ТТТ");
        listStr.add(3, "ТТТ");

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < listStr.size(); i++) {
            answer.append(listStr.get(i) + " ");
        }

        return answer.toString().trim();
    }

    @Test
    void checkReceiptAnItemFromLinkedList() {
        assertEquals("молоко фасоль;", getAnItemFromList("молоко банан хлеб фасоль", 0, 3));
        assertEquals("хлеб банан;", getAnItemFromList("молоко банан хлеб фасоль", 2, 1));
        assertThrows(IndexOutOfBoundsException.class, () ->
                getAnItemFromList("молоко банан хлеб фасоль", 2, 12));
        assertThrows(IndexOutOfBoundsException.class, () ->
                getAnItemFromList("молоко банан хлеб фасоль", 2, -22));
    }

    public String getAnItemFromList(String string, int index1, int index2) throws RuntimeException {

        LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
        stringToList(listStr, string.split(" "));
        return String.format("%s %s;", listStr.get(index1), listStr.get(index2));

    }

    @Test
    void checkingReplacementAnItemInLinkedList() {
        assertEquals("Заменил это: очень, на это: WWW",
                replacesAnItemInListByIndex("много очень часто в сайте", 1, "WWW"));
        assertEquals("Заменил это: много, на это: GGG",
                replacesAnItemInListByIndex("много очень часто в сайте", 0, "GGG"));
        assertEquals("Заменил это: сайте, на это: XXX",
                replacesAnItemInListByIndex("много очень часто в сайте", 4, "XXX"));
        assertThrows(IndexOutOfBoundsException.class, () ->
                replacesAnItemInListByIndex("много очень часто в сайте", 6, "ZZZ"));
        assertThrows(IndexOutOfBoundsException.class, () ->
                replacesAnItemInListByIndex("много очень часто в сайте", -12, "ZZZ"));
    }

    public String replacesAnItemInListByIndex(String string, int setIndex, String replacementString) throws RuntimeException {
        LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
        stringToList(listStr, string.split(" "));
        return String.format("Заменил это: %s, на это: %s",
                listStr.set(setIndex, replacementString),
                listStr.get(setIndex));

    }

    @Test
    void checkingDeletionAnItemFromLinkedList() {
        assertEquals("Удалил это: вкусно", removesAnItemFromTheListByIndex("много мало вкусно надо", 2));
        assertEquals("Удалил это: много", removesAnItemFromTheListByIndex("много мало вкусно надо", 0));
        assertEquals("Удалил это: надо", removesAnItemFromTheListByIndex("много мало вкусно надо", 3));
        assertThrows(IndexOutOfBoundsException.class, () -> removesAnItemFromTheListByIndex("много мало вкусно надо", 12));
        assertThrows(IndexOutOfBoundsException.class, () -> removesAnItemFromTheListByIndex("много мало вкусно надо", -2));
    }

    public String removesAnItemFromTheListByIndex(String string, int removeIndex) throws RuntimeException {
        LinkedListByEfckoTypeString listStr = new LinkedListByEfckoTypeString();
        stringToList(listStr, string.split(" "));
        return String.format("Удалил это: %s", listStr.remove(removeIndex));
    }

    @Test
    void checkGetIndexAnElement() {
        assertEquals("Получил индекс слова хлеб: 3",
                testIndexOf("кушай не обляпайся, хлеб очень вкусный", "хлеб"));
        assertEquals("Получил индекс слова хлеб: 0",
                testIndexOf("кушай не обляпайся, хлеб очень вкусный", "кушай"));
        assertEquals("Получил индекс слова хлеб: 5",
                testIndexOf("кушай не обляпайся, хлеб очень вкусный", "вкусный"));
        assertEquals("Получил индекс слова хлеб: -1",
                testIndexOf("кушай не обляпайся, хлеб очень вкусный", "чай"));
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
}
