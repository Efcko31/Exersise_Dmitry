package ru.Stack;

import org.junit.platform.commons.util.StringUtils;

import java.util.Stack;

public class CalculatorByRPN {
    // "15/(7-(1+1))*3-(2+(1+1))*15/(7-(200+1))*3-(2+(1+1))*(15/(7-(1+1))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1)))"

    private static int getPriority(char token) { //почему этот метод я вижу до основго, где он используется???
        switch (token) {
            case '*':
            case '/':
                return 4;
            case '+':
            case '-':
                return 3;
            case '(':
                return 2;
            case ')':
                return 1;
        }
        return -1;
    }

    public static Double ExpressionToRPN(String expression) throws RuntimeException { //нейминг, неверное назчаение
        StringBuilder currentString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int priority;

        //expression.split("[+--*()//]", -1, true) Смотри и ахуевай
        for (int i = 0; i < expression.length(); i++) {
            priority = getPriority(expression.charAt(i));

            if (priority == -1) {
                currentString.append(expression.charAt(i)); // todo часть case
            } else if (priority == 2) {
                stack.push(expression.charAt(i));
                currentString.append(" ");    // todo часть case
            } else if (priority > 2) {
                currentString.append(" ");

                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        currentString.append(stack.pop());

                    } else {
                        break; //todo хреново написаное услове в while
                    }
                }
                stack.push(expression.charAt(i));
            } else if (priority == 1) {
                currentString.append(" ");
                while (!stack.empty() && getPriority(stack.peek()) != 2) {
                    currentString.append(stack.pop());

                }
                if (!stack.empty()) {
                    stack.pop();
                }
            }
        }
        while (!stack.empty()) {
            currentString.append(stack.pop());
        }
        return RPNToAnswer(currentString.toString());
    }

    public static double RPNToAnswer(String rpn) {
        StringBuilder operand = new StringBuilder();
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' '); // массив
            else if (getPriority(rpn.charAt(i)) == -1) {
                while (i < rpn.length() && rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == -1) {
                    operand.append(rpn.charAt(i++));
                }
                i--;
                stack.push(Double.parseDouble(operand.toString()));
                operand = new StringBuilder();
            } else if (getPriority(rpn.charAt(i)) > 2) {
                double a = stack.pop();
                double b = stack.pop();

                if (rpn.charAt(i) == '+') stack.push(b + a);
                else if (rpn.charAt(i) == '-') stack.push(b - a);
                else if (rpn.charAt(i) == '*') stack.push(b * a);
                else if (rpn.charAt(i) == '/') stack.push(b / a);
            }
        }
        return stack.pop();
    }
}
