package ru.Optional.Exersises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex2 {
    //Напишите метод, который принимает List<Integer> и возвращает Optional<Integer>,
    //содержащий первое четное число, если оно есть, иначе — Optional.empty().

    @Test
    void findsTheFirstEvenNumberTest() {
        assertEquals(Optional.of(8), findsTheFirstEvenNumber(List.of(1, 3, 5, 8, 10)));
        assertEquals(Optional.empty(), findsTheFirstEvenNumber(List.of(1, 3, 5)));
        assertEquals(Optional.empty(), findsTheFirstEvenNumber(null));
    }

    public Optional<Integer> findsTheFirstEvenNumber(List<Integer> numbers) {
        return Optional.ofNullable(numbers)
                .flatMap(n -> n.stream()
                        .filter(a -> a % 2 == 0)
                        .findFirst());
    }

    //Напишите метод, который принимает Optional<String> (email) и возвращает Optional<String>
    //с доменной частью (после @). Если email невалидный или Optional пуст — вернуть Optional.empty().
    @Test
    void returnsTheDomainPartOfTheMailAddressAfterAmpersatSignTest() {
        assertEquals(Optional.of("example.com"),
                returnsTheDomainPartOfTheMailAddressAfterAmpersatSign(Optional.of("user@example.com")));
        assertEquals(Optional.empty(),
                returnsTheDomainPartOfTheMailAddressAfterAmpersatSign(Optional.of("user4example.com")));
        assertEquals(Optional.empty(),
                returnsTheDomainPartOfTheMailAddressAfterAmpersatSign(Optional.empty()));
    }

    public Optional<String> returnsTheDomainPartOfTheMailAddressAfterAmpersatSign(Optional<String> email) {
        return email.filter(s -> s.contains("@"))
                .map(s -> s.split("@")[1]);
    }

    //Напишите метод, который принимает два Optional<Integer> и возвращает их сумму.
    //Если хотя бы один Optional пуст — вернуть Optional.empty().
    @Test
    void countsTheSumOfTwoIncomingValuesTest() {
        assertEquals(Optional.of(8), countsTheSumOfTwoIncomingValues(Optional.of(3), Optional.of(5)));
        assertEquals(Optional.empty(), countsTheSumOfTwoIncomingValues(Optional.empty(), Optional.of(5)));
        assertEquals(Optional.empty(), countsTheSumOfTwoIncomingValues(Optional.of(3), Optional.empty()));
        assertEquals(Optional.empty(), countsTheSumOfTwoIncomingValues(Optional.empty(), Optional.empty()));
    }

    public Optional<Integer> countsTheSumOfTwoIncomingValues(Optional<Integer> val1, Optional<Integer> val2) {
        return val1.flatMap(a -> val2.map(b -> a + b));
    }
    //Напишите метод, который принимает Optional<String> и проверяет, что длина строки больше 5 символов.
    //Верните Optional<Boolean>. Если Optional пуст — Optional.empty().
    @Test
    void checksThatTheStringLengthIsMoreThanFiveCharactersTest() {
        assertEquals(Optional.of(true),
                checksThatTheStringLengthIsMoreThanFiveCharacters(Optional.of("Hello")));
        assertEquals(Optional.of(false),
                checksThatTheStringLengthIsMoreThanFiveCharacters(Optional.of("Hi")));
        assertEquals(Optional.empty(),
                checksThatTheStringLengthIsMoreThanFiveCharacters(Optional.empty()));
    }
    public Optional<Boolean> checksThatTheStringLengthIsMoreThanFiveCharacters(Optional<String> string) {
        return string.map(s -> s.length() >= 5);
    }

    //Напишите метод, который принимает List<List<Integer>> и возвращает Optional<Integer> с
    //минимальным числом из всех вложенных списков. Если списки пусты или null — вернуть Optional.empty().
    @Test
    void test() {}
}
