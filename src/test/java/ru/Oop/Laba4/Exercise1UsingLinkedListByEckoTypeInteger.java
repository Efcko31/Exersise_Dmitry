package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;
import ru.MyLinkedList.MyLinkedListInteger.ElementByEfckoTypeInteger;
import ru.MyLinkedList.MyLinkedListInteger.LinkedListByEfckoTypeInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise1UsingLinkedListByEckoTypeInteger {
    /*Дана последовательность целых чисел. Вывести упорядоченную по возрастанию
последовательность, состоящую из чисел данной последовательности, стоящих на
нечётных местах и встречающихся в ней только один раз.*/
    @Test
    public void test() {
        assertArrayEquals(new Integer[]{7, 15, 32}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{3, 4, 4, 4, 5, 5, 5, 2, 2, 2, 6, 7, 45, 32, 122, 15}));
        assertArrayEquals(new Integer[]{4, 5, 6, 8}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{1, 2, 3, 8, 1, 6, 7, 7, 7, 9, 9, 5, 2, 4}));
        assertArrayEquals(new Integer[]{}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
        assertArrayEquals(new Integer[]{}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{2, 2, 3, 3, 7, 4, 5, 5, 6, 6, 7, 6, 4, 4}));
        assertArrayEquals(new Integer[]{0, 2, 4, 6, 8}, sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{1, 8, 3, 6, 5, 2, 7, 0, 9, 4}));
        assertThrows(NullPointerException.class, () -> sortsNumbersInAscendingOrderStandingInOddPlaces
                (new Integer[]{}));
    }

    public Integer[] sortsNumbersInAscendingOrderStandingInOddPlaces(Integer[] numbers) throws NullPointerException {
        try {
            Laba4Util.checkArrayIsEmpty(numbers);
            LinkedListByEfckoTypeInteger numbersDuplicateList = new LinkedListByEfckoTypeInteger();
            LinkedListByEfckoTypeInteger listForAnswer = new LinkedListByEfckoTypeInteger();

            return removesDuplicatesAndOddIndexes(numbersDuplicateList, listForAnswer, numbers);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public LinkedListByEfckoTypeInteger insertingAnElementByValue(LinkedListByEfckoTypeInteger numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            Integer x = numbersList.get(i);
            int j = i;
            while (j > 0 && numbersList.get(j - 1) > x) {
                numbersList.set(j, numbersList.get(j - 1));
                --j;
            }
            numbersList.set(j, x);
        }
        return numbersList;
    }

    public Integer[] removesDuplicatesAndOddIndexes(LinkedListByEfckoTypeInteger numbersDuplicateList,
                                                    LinkedListByEfckoTypeInteger listForAnswer,
                                                    Integer[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            if (!containsElem(listForAnswer, numbers[i])) {
                if (i % 2 != 0 & !containsElem(numbersDuplicateList, numbers[i])) {
                    listForAnswer.add(numbers[i]);
                } else {
                    numbersDuplicateList.add(numbers[i]);
                }
            } else {
                listForAnswer.remove(searchIndexElement(listForAnswer, numbers[i]));
                numbersDuplicateList.add(numbers[i]);
            }
        }
        return transfersDataFromListToArray(insertingAnElementByValue(listForAnswer));
    }

    public Integer[] transfersDataFromListToArray(LinkedListByEfckoTypeInteger listForAnswer) {
        Integer[] answer = new Integer[listForAnswer.size()];
        for (int i = 0; i < listForAnswer.size(); i++) {
            answer[i] = listForAnswer.get(i);
        }
        return answer;
    }

    public boolean containsElem(LinkedListByEfckoTypeInteger listForAnswer, int data) {
        ElementByEfckoTypeInteger element =  listForAnswer.getHead();
        for (int i = 0; i < listForAnswer.size() && element.getData() != null; i++) {
            if (element.getData() == data) {
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    public int searchIndexElement(LinkedListByEfckoTypeInteger listForAnswer, int data) {
        ElementByEfckoTypeInteger element = new ElementByEfckoTypeInteger(null, listForAnswer.getHead());
        for (int i = 0; i < listForAnswer.size(); i++) {
            if (element.getNext().getData() == data) {
                return i;
            }
            element = element.getNext();
        }
        return -1;
    }
}
