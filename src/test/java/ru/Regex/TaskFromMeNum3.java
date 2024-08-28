package ru.Regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFromMeNum3 {

    @Test
    public void test() {
        assertEquals("(19)(2.19)(8.1.19); 3 раз(а).", lazyQuantifier("192.198.1.195"));

        assertEquals("(захватывает 19)(2 символы .19)(8 что стоят .1перед совпадениями. но не19); 3 раз(а).",
                lazyQuantifier("захватывает 192 символы .198 что стоят .1перед совпадениями. но не19 после5"));
    }

    private String lazyQuantifier(String string) {
        Pattern pattern = Pattern.compile(".*?19");
        Matcher matcher = pattern.matcher(string);
        StringBuilder answer = new StringBuilder();
        var counter = 0;

        while (matcher.find()) {
            counter++;
            answer.append("(").append(matcher.group()).append(")");
        }
    return answer.append("; ").append(counter).append(" раз(а).").toString();
    }
}
