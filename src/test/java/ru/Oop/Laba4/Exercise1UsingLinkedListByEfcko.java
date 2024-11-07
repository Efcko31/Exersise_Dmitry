package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;
import ru.Oop.LinkedListByEfckoAllType.ElementByEfcko;
import ru.Oop.LinkedListByEfckoAllType.LinkedListByEfcko;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise1UsingLinkedListByEfcko {
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
            LinkedListByEfcko<Integer> numbersDuplicateList = new LinkedListByEfcko<>();
            LinkedListByEfcko<Integer> listForAnswer = new LinkedListByEfcko<>();

            return removesDuplicatesAndOddIndexes(numbersDuplicateList, listForAnswer, numbers);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public LinkedListByEfcko<Integer> insertingAnElementByValue(LinkedListByEfcko<Integer> numbersList) {
        for( int i = 0; i < numbersList.size(); i++) {
            int x = numbersList.get(i);
            int j = i;
            while (j > 0 &&  numbersList.get(j - 1) > x) {
                numbersList.set(j, numbersList.get(j - 1));
                --j;
            }
            numbersList.set(j, x);
        }
    return numbersList;
    }

    public Integer[] removesDuplicatesAndOddIndexes(LinkedListByEfcko<Integer> numbersDuplicateList,
                                               LinkedListByEfcko<Integer> listForAnswer,
                                               Integer[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            if (!listForAnswer.contains(numbers[i])){
                if (i % 2 != 0 & !numbersDuplicateList.contains(numbers[i])) {
                    listForAnswer.add(new ElementByEfcko<>(numbers[i]));
                } else {
                    numbersDuplicateList.add(new ElementByEfcko<>(numbers[i]));
                }
            } else {
                listForAnswer.remove(listForAnswer.indexOf(numbers[i]));
                numbersDuplicateList.add(new ElementByEfcko<>(numbers[i]));
            }
        }
        return transfersDataFromListToArray(insertingAnElementByValue(listForAnswer));
    }

    public Integer[] transfersDataFromListToArray(LinkedListByEfcko<Integer> listForAnswer) {
        Integer[] answer = new Integer[listForAnswer.size()];
        for (int i = 0; i < listForAnswer.size(); i++) {
            answer[i] = listForAnswer.get(i);
        }
        return answer;
    }
}
