package ru.Stak.Calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorByRPNTest {
    @Test
    void test(){
        Assertions.assertEquals(6.0d, CalculatorByRPN.Calculator("2+2*2"));
        Assertions.assertEquals(8.0d, CalculatorByRPN.Calculator("(2+2)*2"));
        Assertions.assertEquals(-30.072164948453608d, CalculatorByRPN.Calculator(
                "15/(7-(1+1))*3-(2+(1+1))*15/(7-(200+1))*3-(2+(1+1))*(15/(7-(1+1))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1)))"));
        Assertions.assertEquals(5.0d, CalculatorByRPN.Calculator("(6+10-4)/(1+1*2)+1"));
        Assertions.assertEquals(6.0d, CalculatorByRPN.Calculator("(8+2*5)/(1+3*2-4)"));
    }
}
