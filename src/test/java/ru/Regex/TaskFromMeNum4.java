package ru.Regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFromMeNum4 {
    @Test
    public void test() {
        assertEquals("(192.198.1.19); 1 раз(а).", greedyQuantifier("192.198.1.195"));

        assertEquals("(поглащает192всю.строку до  последнего совпадения197.и отбросит все после последнего совпадения1.19); 1 раз(а).",
                greedyQuantifier("поглащает192всю.строку до  последнего совпадения197.и отбросит все после последнего совпадения1.19555555555"));

    }

    private String greedyQuantifier(String string) {
        Pattern pattern = Pattern.compile(".*19");
        Matcher matcher = pattern.matcher(string);
        StringBuilder answer = new StringBuilder();
        int counter = 0;

        while (matcher.find()) {
            counter++;
            answer.append("(").append(matcher.group()).append(")");
        }
        return answer.append("; ").append(counter).append(" раз(а).").toString();
    }
}
