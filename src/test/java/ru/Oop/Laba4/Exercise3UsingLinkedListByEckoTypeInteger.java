package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;
import ru.DTO.ElementByEfckoTypeInteger;
import ru.DTO.LinkedListByEfckoTypeInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise3UsingLinkedListByEckoTypeInteger {
    /* Если число x встречается в последовательности, то упорядочить по убыванию часть последовательности до последнего
    вхождения x */
    @Test
    public void test() {
        assertArrayEquals(new Integer[]{9, 7, 6, 3, 4, 2}, checksForPresenceNumberX(
                new Integer[]{9, 3, 7, 6, 4, 2}, 4));
        assertArrayEquals(new Integer[]{9, 7, 3, 6, 4, 1, 2}, checksForPresenceNumberX(
                new Integer[]{9, 3, 7, 6, 4, 1, 2}, 6));
        assertArrayEquals(new Integer[]{1, 3, 5, 4, 2, 9, 7}, checksForPresenceNumberX(
                new Integer[]{1, 3, 5, 4, 2, 9, 7}, 0));
        assertThrows(NullPointerException.class, () -> checksForPresenceNumberX(new Integer[]{}, 0));
    }

    public Integer[] checksForPresenceNumberX(Integer[] numbers, int x) {
        try {
            Laba4Util.checkArrayIsEmpty(numbers);
            LinkedListByEfckoTypeInteger numbersArray = new LinkedListByEfckoTypeInteger();
            addDataInLinkedListByEfcko(numbers, numbersArray);

            int indexX = searchLastIndexElement(numbersArray, x);
            insertingAnElementByValue(numbersArray, indexX);
            return transfersDataFromListToArray(numbersArray);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void insertingAnElementByValue(LinkedListByEfckoTypeInteger numbersList, int stop) {
        for (int i = 0; i < stop; i++) {
            int x = numbersList.get(i);
            int j = i;
            while (j > 0 && numbersList.get(j - 1) < x) {
                numbersList.set(j, numbersList.get(j - 1));
                --j;
            }
            numbersList.set(j, x);
        }
    }

    public Integer[] transfersDataFromListToArray(LinkedListByEfckoTypeInteger listForAnswer) {
        Integer[] answer = new Integer[listForAnswer.size()];
        for (int i = 0; i < listForAnswer.size(); i++) {
            answer[i] = listForAnswer.get(i);
        }
        return answer;
    }

    public void addDataInLinkedListByEfcko(Integer[] numbers, LinkedListByEfckoTypeInteger numbersArray) {
        for (int i = 0; i < numbers.length; i++) {
            numbersArray.add(numbers[i]);
        }
    }

    public int searchLastIndexElement(LinkedListByEfckoTypeInteger numbersArray, int data) {
        ElementByEfckoTypeInteger element = new ElementByEfckoTypeInteger(null, numbersArray.getHead());
        int index = -1;
        for (int i = 0; i < numbersArray.size(); i++) {
            if (element.getNext().getData() == data) {
                index = i;
            }
            element = element.getNext();
        }
        return index;
    }
}
