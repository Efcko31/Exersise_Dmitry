package ru.Tree;


import org.junit.jupiter.api.Test;
import ru.Tree.BinaryTreeNodeInteger.BinaryTreeInteger;
import ru.Tree.BinaryTreeNodeInteger.NodeBinaryTreeInteger;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    BinaryTreeInteger threeTest = insertingNodeIntoTreeTest();

    @Test
    public void test() {
        assertNotNull(insertingNodeIntoTreeTest().getRootNode());
    }

    public BinaryTreeInteger insertingNodeIntoTreeTest() {
        BinaryTreeInteger threeTest = new BinaryTreeInteger();
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
        assertTrue(deletesDataFromTree(threeTest, 63));
        assertFalse(deletesDataFromTree(threeTest, 199));
    }

    public boolean deletesDataFromTree( BinaryTreeInteger threeTest, Integer delNodeKey) {
        boolean answer = threeTest.delete(delNodeKey);
        threeTest.symmetricalTreeTraversal(threeTest.getRootNode());
        return answer;
    }

    @Test
    public void findMaximumMinimumMethodsTest() {
        assertEquals(new NodeBinaryTreeInteger(33, 1.7), threeTest.find(33));
        assertNull(threeTest.find(44));
        assertEquals(75, threeTest.maximum().getKey());
        assertEquals(10, threeTest.minimum().getKey());
    }
}
