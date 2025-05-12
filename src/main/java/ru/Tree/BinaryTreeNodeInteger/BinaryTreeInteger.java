package ru.Tree.BinaryTreeNodeInteger;

import lombok.Data;

@Data
public class BinaryTreeInteger {
    private NodeBinaryTreeInteger rootNode;

    public BinaryTreeInteger() {
        rootNode = null;
    }

    public boolean delete(Integer key) {
        if(rootNode == null) {
            System.out.println("Дерево или корень пустые!");
            return false;
        }

        NodeBinaryTreeInteger current = rootNode;
        NodeBinaryTreeInteger parent = rootNode;
        boolean isLeftChild = true;

        while (current.getKey() != key) {
            parent = current;
            if (key < current.getKey()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                System.out.println("Узел не найден");
                return false;
            }
        }

        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == rootNode) {
                rootNode = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (current == rootNode) {
                rootNode = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == rootNode) {
                rootNode = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            NodeBinaryTreeInteger successor = getSuccessor(current);

            if (current == rootNode) {
                rootNode = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());

        }
        return true;
    }


    private NodeBinaryTreeInteger getSuccessor(NodeBinaryTreeInteger delNode) {
        NodeBinaryTreeInteger successorParent = delNode;
        NodeBinaryTreeInteger successor = delNode;
        NodeBinaryTreeInteger current = delNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != delNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    public void insert(Integer key, Double value) {

        NodeBinaryTreeInteger newNode = new NodeBinaryTreeInteger(key, value);

        if (rootNode == null) {
            rootNode = newNode;
        } else {
            NodeBinaryTreeInteger currentNode = rootNode;
            NodeBinaryTreeInteger parent;

            while (true) {
                parent = currentNode;
                if (key < currentNode.getKey()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public NodeBinaryTreeInteger find(Integer key) {
        NodeBinaryTreeInteger current = rootNode;

        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }

            if (current == null) {
                System.out.println("Узел не найден");
                return null;
            }
        }
        return current;
    }

    public NodeBinaryTreeInteger minimum() {
        NodeBinaryTreeInteger current = rootNode;
        NodeBinaryTreeInteger last = current;

        while(current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public NodeBinaryTreeInteger maximum() {
        NodeBinaryTreeInteger current = rootNode;
        NodeBinaryTreeInteger last = current;

        while(current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }

    public void symmetricalTreeTraversal(NodeBinaryTreeInteger root) {
        inOrder(root);
    }

    private void inOrder(NodeBinaryTreeInteger localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.getLeftChild());

            System.out.print(localRoot.getKey() + " ");
            inOrder(localRoot.getRightChild());
        }
    }
}
