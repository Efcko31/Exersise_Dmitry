package ru.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Theory {

    // 1 1 2 3 5 8 13
    @Test
    void calculateArray () {
        Assertions.assertEquals(13, calculateFibonachi(7));
        Assertions.assertEquals(13, calculateFibonachi(1,1,7,2));


    }


    private int calculateFibonachi(int indexOfLastElement) {
        var previous = 1;
        var current = 1;
        for(int i = 3; i <= indexOfLastElement; i++) {
            var tmp = previous + current;
            previous = current;
            current = tmp;
        }
        return current;
    }

    private int calculateFibonachi(int previous, int current, int indexOfLastElement, int indexOfCurrentElement) {
        if (indexOfLastElement == indexOfCurrentElement) {
            return  current;
        }
        var tmp = previous + current;
        previous = current;
        current = tmp;
        indexOfCurrentElement++;
        return calculateFibonachi(previous, current, indexOfLastElement, indexOfCurrentElement);
    }

}
