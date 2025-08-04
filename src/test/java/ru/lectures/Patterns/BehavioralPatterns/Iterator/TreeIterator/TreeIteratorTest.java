package ru.lectures.Patterns.BehavioralPatterns.Iterator.TreeIterator;

import java.util.Iterator;

public class TreeIteratorTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        Iterator<Integer> it = new TreeIterator(root);
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
