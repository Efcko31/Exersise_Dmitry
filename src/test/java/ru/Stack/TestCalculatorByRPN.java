package ru.Stack;

import org.junit.jupiter.api.Test;

import static ru.Stack.CalculatorByRPN.ExpressionToRPN;

public class TestCalculatorByRPN {
    @Test
    void test(){
        System.out.println(ExpressionToRPN("2+2*2"));
        System.out.println(ExpressionToRPN("(2+2)*2"));
        System.out.println(ExpressionToRPN(
                "15/(7-(1+1))*3-(2+(1+1))*15/(7-(200+1))*3-(2+(1+1))*(15/(7-(1+1))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1)))"));
        System.out.println(ExpressionToRPN("(6+10-4)/(1+1*2)+1"));
        System.out.println(ExpressionToRPN("(8+2*5)/(1+3*2-4)"));
    }
}
