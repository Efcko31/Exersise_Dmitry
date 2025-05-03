package ru.Tree.BinaryTreeNodeInteger;

public class BinaryTreeInteger {
    private NodeBinaryTreeInteger rootNode;

    public BinaryTreeInteger() {
        rootNode = null;
    }

    public void insert(Integer value) {

        NodeBinaryTreeInteger newNode = new NodeBinaryTreeInteger(value);

        if (rootNode == null) {
            rootNode = newNode;
        } else {
            NodeBinaryTreeInteger currentNode = rootNode;

            if (value < data) {
                if (leftChild == null) {
                    leftChild = new NodeBinaryTreeInteger(value);
                } else {
                    leftChild.insert(value);
                }
            } else {
                if (rightChild == null) {
                    rightChild = new NodeBinaryTreeInteger(value);
                } else {
                    rightChild.insert(value);
                }
            }
        }


    }
}
