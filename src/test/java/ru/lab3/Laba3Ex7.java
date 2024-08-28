package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex7 {
    //    С клавиатуры вводятся символы. Признак конца ввода — точка. Определить максимальную длину подпоследовательности
//    одинаковых следующих друг за другом символов.
    @Test
    void test() {
        Assertions.assertEquals(2, theMaximumLengthOfIdenticalCharactersInRow(new String[]{"7", "&", "7", "7", ".", "&", "&", "&"}));
        Assertions.assertEquals(8, theMaximumLengthOfIdenticalCharactersInRow(new String[]{"0", "0", "0", "0", "0", "0", "0", "0"}));
        Assertions.assertEquals(1, theMaximumLengthOfIdenticalCharactersInRow(new String[]{"*", ".", "7", "7", ".", "&", "&", "&"}));
        Assertions.assertEquals(0, theMaximumLengthOfIdenticalCharactersInRow(new String[]{".", ".", "7", "7", ".", "&", "&", "&"}));
        Assertions.assertEquals(2, theMaximumLengthOfIdenticalCharactersInRow(new String[]{")(((((((", "(", "*", "3", "*", "*", ".", "&"}));
        Assertions.assertEquals(3, theMaximumLengthOfIdenticalCharactersInRow(new String[]{"**", "**", "**", "7", ".", "&", "&", "&"}));


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
