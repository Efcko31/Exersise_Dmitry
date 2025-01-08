package ru.Stack;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.Stack.CalculatorByRPN.Calculator;

public class CalculatorByRPNTest {
    @Test
    void test(){
        assertEquals(6.0d, Calculator("2+2*2"));
        assertEquals(8.0d, Calculator("(2+2)*2"));
        assertEquals(-30.072164948453608d, Calculator(
                "15/(7-(1+1))*3-(2+(1+1))*15/(7-(200+1))*3-(2+(1+1))*(15/(7-(1+1))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1)))"));
        assertEquals(5.0d, Calculator("(6+10-4)/(1+1*2)+1"));
        assertEquals(6.0d, Calculator("(8+2*5)/(1+3*2-4)"));
    }
}
