package ru.Regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFromMeNum1 {
    // Regex. Проверить входящие адреса сайтов
    @Test
    public void test() {
        assertEquals(true, nameOfWebsite("https://regex101.com/"));

        assertEquals(false, nameOfWebsite("https://regex101com/"));

        assertEquals(false, nameOfWebsite("https://1"));
        assertEquals(true, nameOfWebsite("https://1.com/"));


        assertEquals(true, nameOfWebsite("https://12re2g3ex101.com/"));
    }

    private boolean nameOfWebsite(String name) {
        Pattern pattern = Pattern.compile("(https?:)\\/\\/(\\w*)\\.([a-z]*)\\/");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
}
