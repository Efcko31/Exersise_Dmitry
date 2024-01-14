package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex7 {
//    С клавиатуры вводятся символы. Признак конца ввода — точка. Определить максимальную длину подпоследовательности
//    одинаковых следующих друг за другом символов.
    @Test
    void test(){
        Assertions.assertEquals(2, Ex7(new String[] {"7", "&", "7", "7", ".", "&", "&", "&"}));
        Assertions.assertEquals(8, Ex7(new String[] {"0", "0", "0", "0", "0", "0", "0", "0"}));
        Assertions.assertEquals(1, Ex7(new String[] {"*", ".", "7", "7", ".", "&", "&", "&"}));
        Assertions.assertEquals(0, Ex7(new String[] {".", ".", "7", "7", ".", "&", "&", "&"}));
        Assertions.assertEquals(2, Ex7(new String[] {")(((((((", "(", "*", "3", "*", "*", ".", "&"}));
        Assertions.assertEquals(3, Ex7(new String[] {"**", "**", "**", "7", ".", "&", "&", "&"}));
        // Является ли почледний тест ошибкой? Стоило ли делать массив в типе Char?

    }
    private int Ex7(String[] userData){
        int maxtotal = 0, total = 0;
        String currentValue = userData[0];
        for(int i=0; i < userData.length; i++){
            if(userData[i] == "."){
                break;
            } else if (currentValue == userData[i]) {
                total++;
                if(maxtotal < total)
                    maxtotal = total;
            } else if (currentValue != userData[i]) {
                currentValue = userData[i];
                total = 1;
            }
        }
    return maxtotal;
    }
}
