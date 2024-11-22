package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba3Ex7 {
    //    С клавиатуры вводятся символы. Признак конца ввода — точка. Определить максимальную длину подпоследовательности
//    одинаковых следующих друг за другом символов.
    @Test
    void test() {
        assertEquals(2, theMaximumLengthOfIdenticalCharactersInRow(new String[]{"7", "&", "7", "7", ".", "&", "&", "&"}));
        assertEquals(8, theMaximumLengthOfIdenticalCharactersInRow(new String[]{"0", "0", "0", "0", "0", "0", "0", "0"}));
        assertEquals(1, theMaximumLengthOfIdenticalCharactersInRow(new String[]{"*", ".", "7", "7", ".", "&", "&", "&"}));
        assertEquals(0, theMaximumLengthOfIdenticalCharactersInRow(new String[]{".", ".", "7", "7", ".", "&", "&", "&"}));
        assertEquals(2, theMaximumLengthOfIdenticalCharactersInRow(new String[]{")(((((((", "(", "*", "3", "*", "*", ".", "&"}));
        assertEquals(3, theMaximumLengthOfIdenticalCharactersInRow(new String[]{"**", "**", "**", "7", ".", "&", "&", "&"}));


    }

    private int theMaximumLengthOfIdenticalCharactersInRow(String[] userData) {
        int maxtotal = 0, total = 0;
        String currentValue = userData[0];
        for (int i = 0; i < userData.length && !userData[i].equals("."); i++) {
            if (currentValue == userData[i]) {
                total++;
                if (maxtotal < total)
                    maxtotal = total;
            } else if (currentValue != userData[i]) {
                currentValue = userData[i];
                total = 1;
            }
        }
        return maxtotal;
    }
}
