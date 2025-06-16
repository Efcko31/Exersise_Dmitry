package ru;

import javax.inject.Named;
import java.lang.reflect.Field;

@Named
public class Test {
    public static void main(String[] args) throws Exception {

        String value = "Old value";
        System.out.println(value);

        Field field = value.getClass().getDeclaredField("value");
        field.setAccessible(true);
        field.set(value, "Optional!!".toCharArray());

        System.out.println(value);
    }
}

