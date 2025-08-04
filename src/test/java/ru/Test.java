package ru;

import javax.inject.Named;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
public class Test {
    public static void main(String[] args) throws Exception {

        Pattern pattern = Pattern.compile(".*[0-9].*");
        Matcher matcher = pattern.matcher("Тест на цифры девять 9");
        System.out.println(matcher.matches());
    }
}

