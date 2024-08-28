package ru.Regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFromMeNum2 {
    //Regex - Проверка IP. Вытащить IP адресс.

    @Test

    public void test() {
        assertEquals("192.168.0.2", checkingIPAddress("Мой IP: 192.168.0.2, а твой?"));

        assertEquals("255.222.0.1", checkingIPAddress(
                "Вот.пипец.просто,пробел.сломался.255.222.0.1.и.че.с.этим.делать?"));

        assertEquals("254.222.0.10", checkingIPAddress("ке345234цуа254.222.0.10цужопщцулоап"));

        assertEquals("Not found", checkingIPAddress("254.wdsdf222sdf.dsf0.sdf10sdf"));
    }

    private String checkingIPAddress(String nameAddress) {
        Pattern patternIP = Pattern.compile
                ("(?<!\\d)(?:25[0-5]|2[0-4]\\d|[01]?\\d\\d?)(?:\\.(?:25[0-5]|2[0-4]\\d|[01]?\\d\\d?)){3}(?!\\d)");
        Matcher matcherIP = patternIP.matcher(nameAddress);

        return matcherIP.find() ? matcherIP.group() : "Not found";
    }
}
