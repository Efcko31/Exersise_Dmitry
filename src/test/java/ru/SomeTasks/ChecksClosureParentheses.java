package ru.SomeTasks;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ChecksClosureParentheses {
    @Test
    void test() {
        assertTrue(checksEveryElement("({[]})"));
        assertTrue(checksEveryElement("()[]{}"));
        assertTrue(checksEveryElement("{{{[[((()))]]}}}"));

        assertFalse(checksEveryElement("({[}])"));
        assertFalse(checksEveryElement("([)]"));
        assertFalse(checksEveryElement("(}"));
        assertFalse(checksEveryElement("}}}}}}}})))))]]]"));
        assertFalse(checksEveryElement(")("));

    }

    public boolean checksEveryElement(String exercise) {
        String[] array = exercise.split("");
        ArrayList<String> arrayClose = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if ("({[".contains(array[i])) {
                switch(array[i]) {
                    case "(":
                        arrayClose.add(")");
                        break;
                    case "{":
                        arrayClose.add("}");
                        break;
                    case "[":
                        arrayClose.add("]");
                        break;
                }
            } else if ("})]".contains(array[i])) {
                if (!arrayClose.isEmpty() && array[i].equals(arrayClose.get(arrayClose.size() - 1))) {
                    arrayClose.remove(arrayClose.size() - 1);
                } else {
                    return false;
                }
            }
        }
        if(arrayClose.isEmpty()) {
            return true;
        }
    return false;
    }

}

