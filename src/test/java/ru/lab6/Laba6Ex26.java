package ru.lab6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Laba6Ex26 {
    // Сократить количество пробелов между словами данного предложения до одного.
    @Test

    public void test() {
        Assertions.assertEquals("Привет друг !", removesAllSpacesExceptOne("Привет            друг!"));

        Assertions.assertEquals(" Интересно я правильно сделал? ",
                removesAllSpacesExceptOne("  Интересно   я правильно  сделал?    "));
    }

    private String removesAllSpacesExceptOne(String string) {
        return string.trim().replaceAll("\\s+", " ");
    }
}
