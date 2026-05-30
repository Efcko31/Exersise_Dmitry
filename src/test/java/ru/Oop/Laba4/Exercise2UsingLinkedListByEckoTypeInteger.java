package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;
import ru.myLinkedList.myLinkedListInteger.ElementByEfckoTypeInteger;
import ru.myLinkedList.myLinkedListInteger.LinkedListByEfckoTypeInteger;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise2UsingLinkedListByEckoTypeInteger {

    /*Дана целочисленная последовательность. Определить количество вхождений каждого числа в последовательность.*/

    @Test
    public void test() {
        assertArrayEquals(new Integer[]{3, 3, 7, 1, 8, 1, 6, 2, 4, 3, 5, 4, 9, 2, 2, 2, 1, 1},
                numberOccurrencesEachNumberInArray(new Integer[]{3, 7, 8, 6, 4, 5, 5, 5, 4, 6, 4, 9, 2, 9, 2, 1, 3, 5, 3}));
        assertArrayEquals(new Integer[]{3, 6},
                numberOccurrencesEachNumberInArray(new Integer[]{3, 3, 3, 3, 3, 3}));
        assertArrayEquals(new Integer[]{3, 1},
                numberOccurrencesEachNumberInArray(new Integer[]{3}));
        assertArrayEquals(new Integer[]{0, 6},
                numberOccurrencesEachNumberInArray(new Integer[]{0, 0, 0, 0, 0, 0}));
        assertArrayEquals(new Integer[]{3, 2, 8, 2, 4, 2},
                numberOccurrencesEachNumberInArray(new Integer[]{3, 3, 8, 8, 4, 4}));
        assertArrayEquals(new Integer[]{3, 1, 2, 1, 4, 1, 1, 1, 5, 1, 6, 1, 9, 1, 8, 1, 7, 1},
                numberOccurrencesEachNumberInArray(new Integer[]{3, 2, 4, 1, 5, 6, 9, 8, 7}));
        assertThrows(NullPointerException.class, () -> numberOccurrencesEachNumberInArray
                (new Integer[]{}));
        assertArrayEquals(new Integer[]{0, 5},
                numberOccurrencesEachNumberInArray(new Integer[]{0, 0, 0, null, 0, 0}));
    }

    public Integer[] numberOccurrencesEachNumberInArray(Integer[] numbers) {
        try {
            Laba4Util.checkArrayIsEmpty(numbers);
            LinkedListByEfckoTypeInteger arrayWithValueWithoutRepetitions = new LinkedListByEfckoTypeInteger();
            LinkedListByEfckoTypeInteger arrayNumberRepetitions = new LinkedListByEfckoTypeInteger();
            return writesNumberRepetitionsArray(numbers, arrayWithValueWithoutRepetitions, arrayNumberRepetitions);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Integer[] writesNumberRepetitionsArray(Integer[] numbers,
                                                  LinkedListByEfckoTypeInteger arrayWithValueWithoutRepetitions,
                                                  LinkedListByEfckoTypeInteger arrayNumberRepetitions) {

        for (int i = 0; i < numbers.length; i++) {
            try {
                if (numbers[i] != null && !containsElem(arrayWithValueWithoutRepetitions, numbers[i])) {
                    arrayWithValueWithoutRepetitions.add(numbers[i]);
                    arrayNumberRepetitions.add(1);
                } else if (numbers[i] != null){

                    int index = searchIndexElement(arrayWithValueWithoutRepetitions, numbers[i]);
                    arrayNumberRepetitions.set(index, arrayNumberRepetitions.get(index) + 1);

                }
            } catch (NullPointerException ignored) {}
        }
        return addInArray(arrayWithValueWithoutRepetitions, arrayNumberRepetitions);
    }

    public Integer[] addInArray(LinkedListByEfckoTypeInteger arrayWithValueWithoutRepetitions,
                                LinkedListByEfckoTypeInteger arrayNumberRepetitions) {
        Integer[] arrayForAnswer = new Integer[arrayWithValueWithoutRepetitions.size() + arrayNumberRepetitions.size()];
        int j = 0;
        for (int i = 0; i < arrayForAnswer.length; i += 2) {
            arrayForAnswer[i] = arrayWithValueWithoutRepetitions.get(j);
            arrayForAnswer[i + 1] = arrayNumberRepetitions.get(j);
            j++;
        }
        return arrayForAnswer;
    }

    public boolean containsElem(LinkedListByEfckoTypeInteger listForAnswer, int data) {
        ElementByEfckoTypeInteger element = listForAnswer.getHead();
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
