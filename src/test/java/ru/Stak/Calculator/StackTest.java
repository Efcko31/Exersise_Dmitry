package ru.Stak.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class StackTest {


    @Test
    public void test() {
        Stack<String> box = new Stack<>();
        box.add("red t-short");
        box.add("green t-short");
        box.add("black t-short");

        Assertions.assertEquals(3, box.size());

        Assertions.assertEquals("black t-short", box.pop());
        Assertions.assertEquals(2, box.size());

        box.add("blue t-short");
        Assertions.assertEquals(3, box.size());

        Assertions.assertEquals("blue t-short", box.pop());
        Assertions.assertEquals(2, box.size());


    }
}
