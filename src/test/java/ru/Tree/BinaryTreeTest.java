package ru.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.Tree.BinaryTreeNodeInteger.BinaryTreeInteger;
import ru.Tree.BinaryTreeNodeInteger.NodeBinaryTreeInteger;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    BinaryTreeInteger threeTest = new BinaryTreeInteger();

    @Test
    public void test() {
        threeTest = insertingNodeIntoTreeTest(threeTest);
    }

    public BinaryTreeInteger insertingNodeIntoTreeTest(BinaryTreeInteger threeTest) {
        threeTest.insert(63, 1.0);
        threeTest.insert(47, 1.1);
        threeTest.insert(71, 1.2);
        threeTest.insert(22, 1.3);
        threeTest.insert(53, 1.4);
        threeTest.insert(75, 1.5);
        threeTest.insert(67, 1.6);
        threeTest.insert(33, 1.7);
        threeTest.insert(11, 1.8);
        threeTest.insert(66, 1.9);
        threeTest.insert(50, 2.0);
        threeTest.insert(60, 2.1);
        threeTest.insert(17, 2.2);
        threeTest.insert(49, 2.3);
        threeTest.insert(10, 2.4);
        threeTest.insert(51, 2.5);
        threeTest.symmetricalTreeTraversal(threeTest.getRootNode());
        System.out.println();
        return threeTest;
    }

    @Test
    public void deleteTest() {
        assertTrue(deletesDataFromTree(insertingNodeIntoTreeTest(threeTest), 63));
    }

    public boolean deletesDataFromTree( BinaryTreeInteger threeTest, Integer delNodeKey) {
        threeTest.delete(delNodeKey);
        threeTest.symmetricalTreeTraversal(threeTest.getRootNode());
        return true;
    }

    @Test
    public void findTest() {
        assertEquals(new NodeBinaryTreeInteger(33, 1.7), insertingNodeIntoTreeTest(threeTest).find(33));
        //assertNull(insertingNodeIntoTreeTest(threeTest).find(44));
    }
}
