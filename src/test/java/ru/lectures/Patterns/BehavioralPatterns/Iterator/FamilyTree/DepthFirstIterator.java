package ru.lectures.Patterns.BehavioralPatterns.Iterator.FamilyTree;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstIterator implements Iterator<Person> {
    private Stack<Person> stack = new Stack<>();

    public DepthFirstIterator(Person root) {
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Person next() {
        Person current = stack.pop();
        for (Person child : current.getChildren()) {
            stack.push(child);
        }
        return current;
    }


}
