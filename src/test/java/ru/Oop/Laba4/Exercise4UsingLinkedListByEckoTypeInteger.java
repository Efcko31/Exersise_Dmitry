package ru.Oop.Laba4;

import org.junit.jupiter.api.Test;
import ru.dto.LinkedListByEfckoTypeInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise4UsingLinkedListByEckoTypeInteger {
    /*Дана последовательность целых чисел, содержащая как положительные, так и отрицательные элементы.
    Упорядочить последовательность следующим образом: сначала идут отрицательные числа, упорядоченные по убыванию,
    потом положительные, упорядоченные по возрастанию.*/
    @Test
    public void test() {
        assertArrayEquals(new Integer[]{-7, -9, 2, 3, 4, 5, 6},
                returnsSortedNumbers(new Integer[]{3, -9, 5, -7, 2, 4, 6}));
        assertArrayEquals(new Integer[]{-9, 2, 3, 4, 6, 7}, returnsSortedNumbers(new Integer[]{-9, 3, 7, 6, 4, 2}));
        assertArrayEquals(new Integer[]{-3, -4, -6, -7, -9, 2},
                returnsSortedNumbers(new Integer[]{-9, -3, -7, -6, -4, 2}));
        assertArrayEquals(new Integer[]{2, 3, 4, 6, 7, 9}, returnsSortedNumbers(new Integer[]{9, 3, 7, 6, 4, 2}));
        assertArrayEquals(new Integer[]{-6, -7, -8, -9, 1, 2, 3, 4, 5},
                returnsSortedNumbers(new Integer[]{1, -8, 4, -6, 5, -9, 3, 2, -7}));
        assertThrows(NullPointerException.class, () -> returnsSortedNumbers(new Integer[]{}));
    }

    public Integer[] returnsSortedNumbers(Integer[] numbers) throws NullPointerException {
        try {
            Laba4Util.checkArrayIsEmpty(numbers);
            LinkedListByEfckoTypeInteger positiveNumbersArray = new LinkedListByEfckoTypeInteger();
            LinkedListByEfckoTypeInteger negativeNumbersArray = new LinkedListByEfckoTypeInteger();
            return sortingNonPositiveAndNegativeNumbers(positiveNumbersArray, negativeNumbersArray, numbers);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Integer[] sortingNonPositiveAndNegativeNumbers(LinkedListByEfckoTypeInteger positiveNumbersArray,
                                                          LinkedListByEfckoTypeInteger negativeNumbersArray,
                                                          Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                negativeNumbersArray.add(numbers[i]);
            } else {
                positiveNumbersArray.add(numbers[i]);
            }
        }
        insertingAnElementByValueAscendingOrder(positiveNumbersArray);
        insertingAnElementByValueDescendingOrder(negativeNumbersArray);
        return transfersDataFromListToArray(positiveNumbersArray, negativeNumbersArray);

    }

    public Integer[] transfersDataFromListToArray(LinkedListByEfckoTypeInteger positiveNumbersArray,
                                                  LinkedListByEfckoTypeInteger negativeNumbersArray) {
        Integer[] answer = new Integer[positiveNumbersArray.size() + negativeNumbersArray.size()];
        for (int i = 0; i < answer.length; i++) {
            if (i < negativeNumbersArray.size()) {
                answer[i] = negativeNumbersArray.get(i);
            } else {
                answer[i] = positiveNumbersArray.get(i - negativeNumbersArray.size());
            }

        }
        return answer;
    }

    public void insertingAnElementByValueAscendingOrder(LinkedListByEfckoTypeInteger numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            int x = numbersList.get(i);
            int j = i;
            while (j > 0 && numbersList.get(j - 1) > x) {
                numbersList.set(j, numbersList.get(j - 1));
                --j;
            }
            numbersList.set(j, x);
        }
    }

    public void insertingAnElementByValueDescendingOrder(LinkedListByEfckoTypeInteger numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            int x = numbersList.get(i);
            int j = i;
            while (j > 0 && numbersList.get(j - 1) < x) {
                numbersList.set(j, numbersList.get(j - 1));
                --j;
            }
            numbersList.set(j, x);
        }
    }
}
