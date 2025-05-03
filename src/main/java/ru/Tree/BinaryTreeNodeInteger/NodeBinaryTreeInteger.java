package ru.Tree.BinaryTreeNodeInteger;

import lombok.Data;

@Data
public class NodeBinaryTreeInteger {

    private Integer data;
    private NodeBinaryTreeInteger leftChild;
    private NodeBinaryTreeInteger rightChild;

    public NodeBinaryTreeInteger(Integer data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void printNode() { // Вывод значения узла в консоль
        System.out.println(" Выбранный узел имеет значение :" + data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }


}
