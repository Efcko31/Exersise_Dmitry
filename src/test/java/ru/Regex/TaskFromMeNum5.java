package ru.Regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFromMeNum5 {

    @Test

    public void test() {
        assertEquals("; 0 раз(а).", superGreedyQuantifier("192.197.2.196"));

        assertEquals("; 0 раз(а).", superGreedyQuantifier("19 съела все и ничего не вывела 19"));

        assertEquals("; 0 раз(а).", superGreedyQuantifier("19 зачем она тогда вообще нужна?"));

        assertEquals("; 0 раз(а).", superGreedyQuantifier("если она хлеб пустота не масло 19"));

        assertEquals("; 0 раз(а).", superGreedyQuantifier("какой19в ней19тогда19смысл19?"));
    }

    private String superGreedyQuantifier(String string) {
        Pattern pattern = Pattern.compile(".*+19");
        Matcher matcher = pattern.matcher(string);
        int counter = 0;
        StringBuilder answer = new StringBuilder();

        while (matcher.find()) {
            counter++;
            answer.append("(" + matcher.group() + ")");
        }
    return answer.append("; " + counter + " раз(а).").toString();
    }
}
