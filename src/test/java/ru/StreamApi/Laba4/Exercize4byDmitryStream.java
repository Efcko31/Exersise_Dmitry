package ru.StreamApi.Laba4;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercize4byDmitryStream {
    //На входе есть строка, в которой содержится сумма. Задача распарить это число.
    // Подсказка - выходное число содержится в BigDecimal
    //33435.56 руб
    //2 645 658,37 руб
    //74.658,69 руб
    //1,.5967706,26 руб
    //1,879 538,55 руб


    @Test
    void test() {
        assertEquals(new BigDecimal("33435.56").setScale(2, RoundingMode.CEILING),
                steamsNumber("33435.56 руб"));
        assertEquals(new BigDecimal("2645658.37").setScale(2, RoundingMode.CEILING),
                steamsNumber("2 645 658,37 руб"));
        assertEquals(new BigDecimal("74658.69").setScale(2, RoundingMode.CEILING),
                steamsNumber("74.658,69 руб"));
        assertEquals(new BigDecimal("15967706.26").setScale(2, RoundingMode.CEILING),
                steamsNumber("1,.5967706,26 руб"));
        assertEquals(new BigDecimal("1879538.55").setScale(2, RoundingMode.CEILING),
                steamsNumber("1,879 538,55 руб"));
        assertEquals(new BigDecimal("22789.678"), steamsNumber("22789,678 руб"));
        assertEquals(new BigDecimal("22.12345678"), steamsNumber("22.12345678 руб"));
        assertEquals(new BigDecimal("223567.66").setScale(2, RoundingMode.CEILING),
                steamsNumber("22 3567,66 руб из них 10000 пени"));
        assertEquals(new BigDecimal("223567.66").setScale(2, RoundingMode.CEILING),
                steamsNumber("22 3567,66 руб из них 10000.23 пени"));
    }

    public BigDecimal steamsNumber(String number) {
        Pattern pattern = Pattern.compile("(^\\d[\\d. ]*[.]\\d+)");
        Matcher matcher = pattern.matcher(number.replaceAll("[ ,]", "."));

        StringBuilder answer = new StringBuilder();
        while (matcher.find()) {
            answer.append(matcher.group());
        }
        if (answer.toString().contains(".")) {
            answer.replace(0, answer.lastIndexOf("."), answer.substring(0, answer.lastIndexOf("."))
                    .replaceAll("\\.", ""));
        }
        return new BigDecimal(answer.toString());
    }
}
