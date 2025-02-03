package ru;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.of(2, 3, 0, 5, 3)
                .flatMapToInt(x -> IntStream.range(0, 5
                ))
                .forEach(System.out::println);
    }
}
