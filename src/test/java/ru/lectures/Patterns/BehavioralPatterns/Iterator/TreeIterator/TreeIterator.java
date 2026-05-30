package ru.lectures.Patterns.BehavioralPatterns.Iterator.TreeIterator;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    public Stack<TreeNode> treeStack = new Stack<>();

    public TreeIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while(node != null) {
            treeStack.push(node);
            node = node.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !treeStack.isEmpty();
    }

    @Override
    public Integer next() {
        TreeNode node = treeStack.pop();
        pushLeft(node.right);
        return node.value;
    }
}
