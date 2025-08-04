package ru.lectures.Patterns.BehavioralPatterns.Iterator.FamilyTree;

import java.util.Iterator;

public class familyTreeTest {
    public static void main(String[] args) {
        Person grandpa = new Person("Иван");
        Person father = new Person("Сергей");
        Person son = new Person("Алексей");

        grandpa.addChild(father);
        father.addChild(son);

        Iterator<Person> iterator = new DepthFirstIterator(grandpa);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
