package ru.Tree.BinaryTreeNodeInteger;

import lombok.Data;

@Data
public class NodeBinaryTreeInteger {

    private Integer key;
    private Double someData;
    private NodeBinaryTreeInteger leftChild;
    private NodeBinaryTreeInteger rightChild;

    public NodeBinaryTreeInteger(Integer key, Double someData) {
        this.key = key;
        this.someData = someData;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void printNode() { // Вывод значения узла в консоль
        System.out.println("Узел " + key +  " имеет значение :" + someData);
    }

    @Override
    public String toString() {
        return "Node " + key + "{" +
                "value=" + someData +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }


}
