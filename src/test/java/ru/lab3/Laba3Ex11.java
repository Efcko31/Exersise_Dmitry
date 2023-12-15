package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba3Ex11 {
    //С клавиатуры вводятся символы. Признак конца ввода — точка. Определить символ,
    //следующий за последним вхождением цифры.
    @Test
    void test(){
        Assertions.assertEquals("*", test(new String[] {"+", "1", "*"}));
        Assertions.assertEquals("Nothing", test(new String[] {".", "1", "*"}));
        Assertions.assertEquals("*", test(new String[] {"+", "1", "2", "3", "*", "1", "."}));
        Assertions.assertEquals("Nothing", test(new String[] {"7", "1", "2", "3", "5", "1", "2"}));
        Assertions.assertEquals("%", test(new String[] {"7", "1", "2", "3", "5", "1", "%"}));
        Assertions.assertEquals("Nothing", test(new String[] {"/", "1", "2", "3", "5", "1", "2"}));
        Assertions.assertEquals("/", test(new String[] {"/", "1", "-", "3", "/", "1", ".", "*"}));
    }
    private String test(String [] UserNumber){
        String answer = "Nothing";
        boolean flag = false;
        for(int i=0; i < UserNumber.length; i++){
            if(UserNumber[i] == ".")
                break;
            else if (UserNumber[i] == "1" | UserNumber[i] == "2" | UserNumber[i] == "3" | UserNumber[i] == "4"
                    | UserNumber[i] == "5" | UserNumber[i] == "6" | UserNumber[i] == "7" | UserNumber[i] == "8"
                    | UserNumber[i] == "9" | UserNumber[i] == "0") {
                flag = true;
            } else if(flag == true) {
                answer = UserNumber[i];
                flag = false;
            }
        }
    return answer;
    }
}
