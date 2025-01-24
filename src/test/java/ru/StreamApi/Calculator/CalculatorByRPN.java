package ru.StreamApi.Calculator;

import java.util.Stack;

public class CalculatorByRPN {
    // "15/(7-(1+1))*3-(2+(1+1))*15/(7-(200+1))*3-(2+(1+1))*(15/(7-(1+1))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1)))"


    public static Double Calculator(String expression) throws RuntimeException {
        StringBuilder currentString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
//        expression.split("[+--*()//]", -1, true) Смотри и ахуевай
        for (int i = 0; i < expression.length(); i++) {

            collectsTheStringAsAnRPN(currentString, stack, i, expression);
        }
        while (!stack.empty()) {
            currentString.append(" ");
            currentString.append(stack.pop());

        }
        return calculatesResponse(currentString.toString());
    }

    public static double calculatesResponse(String rpn) {
        String[] rpnArray = rpn.split("\\s++");
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < rpnArray.length; i++) {
            if (!"+-*/".contains(rpnArray[i])/*getPriority(rpn.charAt(i)) == -1*/) {
                stack.push(Double.parseDouble(rpnArray[i]));
            } else {
                double a = stack.pop();
                double b = stack.pop();

                switch (rpnArray[i]) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private static int getPriority(char token) {
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

    private static void collectsTheStringAsAnRPN(StringBuilder currentString, Stack<Character> stack, int i, String expression) {

        switch (getPriority(expression.charAt(i))) {
            case -1:
                currentString.append(expression.charAt(i));
                break;
            case 1:
                currentString.append(" ");
                while (!stack.empty() && getPriority(stack.peek()) != 2) {
                    currentString.append(stack.pop());
                    currentString.append(" ");

                }
                if (!stack.empty()) {
                    stack.pop();
                }
                break;
            case 2:
                stack.push(expression.charAt(i));
                break;
            case 3:
            case 4:
                currentString.append(" ");
                while (!stack.empty() && getPriority(stack.peek()) >= getPriority(expression.charAt(i))) {
                    currentString.append(stack.pop());
                    currentString.append(" ");
                }
                stack.push(expression.charAt(i));
                break;
        }
    }
}
