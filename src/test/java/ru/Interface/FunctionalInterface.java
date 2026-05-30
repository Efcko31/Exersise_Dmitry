package ru.Interface;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FunctionalInterface {
    public static void main(String[] args) {
      // predicateTest();
       // binaryOperatorTest();
        unaryOperatorTest();
    }

    public static void predicateTest() {
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isEquals = x -> x == 0;

        System.out.println("Integer test ");
        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(-7));
        System.out.println(isPositive.or(isEquals).test(4));
        System.out.println(isPositive.and(isEquals).test(6));
        System.out.println(isPositive.negate().test(-7));
        System.out.println("String test ");
        Predicate<String> isContain = s -> s.contains("о");
        System.out.println(isContain.test("Слово"));
        System.out.println(isContain.test("Шаурма"));
    }

    public static void binaryOperatorTest() {
        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println(multiply.apply(3, 5));
        System.out.println(multiply.apply(10, -2));
        System.out.println(multiply.andThen(z -> z * 10).apply(2, 6));
    }

    public static void unaryOperatorTest() {
        UnaryOperator<Integer> square = x -> x*x;
        UnaryOperator<Integer> xor = a -> a + 1;
        UnaryOperator<Integer> and = a -> a + 3;
        System.out.println(xor.apply(5));
        System.out.println(and.apply(2));
        System.out.println(square.apply(5));
        System.out.println(xor.compose(and).apply(231));
    }
}

