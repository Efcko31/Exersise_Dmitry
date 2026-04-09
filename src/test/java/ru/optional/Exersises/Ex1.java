package ru.optional.Exersises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex1 {
    //Возвращает длину строки
    @Test
    void countsTheLengthOfTheStringTest() {
        assertEquals(Optional.of(4), countsTheLengthOfTheString("Java"));
        assertEquals(Optional.empty(), countsTheLengthOfTheString(""));
        assertEquals(Optional.empty(), countsTheLengthOfTheString(null));
    }

    public Optional<Integer> countsTheLengthOfTheString(String string) {
        return Optional.ofNullable(string)
                .filter(s -> !s.isEmpty())
                .map(String::length);
    }

    //Написать метод, который принимает List<Integer>
    //и возвращает Optional с максимальным значением, если список не пустой, иначе пустой Optional
    @Test
    void lookingForTheMaximumValueTest() {
        assertEquals(Optional.of(5), lookingForTheMaximumValue(List.of(1, 2, 3, 4, 5)));
        assertEquals(Optional.of(7), lookingForTheMaximumValue(List.of(1, 2, 7, 4, 5)));
        assertEquals(Optional.of(10), lookingForTheMaximumValue(List.of(10, 2, 3, 4, 5)));
        assertEquals(Optional.of(-1), lookingForTheMaximumValue(List.of()));
        assertEquals(Optional.empty(), lookingForTheMaximumValue(null));
    }

    public Optional<Integer> lookingForTheMaximumValue(List<Integer> numbers) {
        return Optional.ofNullable(numbers)
                .map(s -> s.stream()
                        .mapToInt(n -> n)
                        .max()
                        .orElse(-1));
    }

    //Написать метод, который принимает два Optional<Integer>
    //и возвращает сумму их значений, если оба присутствуют, иначе возвращает 0
    @Test
    void countsTheSumOfTwoIncomingValuesTest() {
        assertEquals(7, countsTheSumOfTwoIncomingValues(Optional.of(3), Optional.of(4)));
        assertEquals(0, countsTheSumOfTwoIncomingValues(Optional.empty(), Optional.of(4)));
        assertEquals(0, countsTheSumOfTwoIncomingValues(Optional.of(3), Optional.empty()));
        assertEquals(0, countsTheSumOfTwoIncomingValues(Optional.empty(), Optional.empty()));
    }

    public Integer countsTheSumOfTwoIncomingValues(Optional<Integer> val1, Optional<Integer> val2) {
        return val1.flatMap(a -> val2.map(b -> a + b)).orElse(0);
//        return Optional.ofNullable(val1).isPresent() & Optional.ofNullable(val2).isPresent()
//                ? val1 + val2
//                : 0;
    }

    //Написать метод, который принимает Optional<User> (где User — класс с полем name)
    //и возвращает имя пользователя в верхнем регистре, если пользователь присутствует,
    //иначе возвращает "DEFAULT"
    @Test
    void returnsTheUserSNameInUppercaseTest() {
        assertEquals("АНТОН", returnsTheUserSNameInUppercase(
                Optional.of(new UserForEx1Optional("Антон"))));
        assertEquals("DEFAULT", returnsTheUserSNameInUppercase(
                Optional.of(new UserForEx1Optional())));
    }

    public String returnsTheUserSNameInUppercase(Optional<UserForEx1Optional> user) {
        return user.map(UserForEx1Optional::getName)
                .map(String::toUpperCase)
                .orElse("DEFAULT");
        //return Optional.ofNullable(user.getName()).isPresent() ? user.getName().toUpperCase() : "DEFAULT";
    }
}
