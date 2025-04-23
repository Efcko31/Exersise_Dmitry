package ru.OptionalTest;

import org.junit.jupiter.api.Test;
import ru.Optional.UsersOptional;

import java.util.Arrays;

import static ru.Optional.Methods.getValidTicketNumber;
import static ru.Optional.Methods.getValidTicketNumberConcert;
import static ru.Optional.UsersOptional.*;

public class OptionalTest {
    @Test
    void test(){
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
