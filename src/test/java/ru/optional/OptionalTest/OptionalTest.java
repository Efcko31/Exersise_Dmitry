package ru.optional.OptionalTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ru.optional.Methods.getValidTicketNumber;
import static ru.optional.Methods.getValidTicketNumberConcert;
import static ru.optional.UsersOptional.values;

public class OptionalTest {
    @Test
    void test() {
        Arrays.stream(values())
                .forEach(u -> System.out.println(getValidTicketNumber(u.getUser())));
        System.out.println("_________________________");
        Arrays.stream(values())
                .forEach(u -> System.out.println(
                        getValidTicketNumberConcert(u.getUser(), "Горе от ума")));
        System.out.println("_________________________");
        Arrays.stream(values())
                .forEach(u -> System.out.println(
                        getValidTicketNumberConcert(u.getUser(), "Ирония судьбы")));
    }
}
