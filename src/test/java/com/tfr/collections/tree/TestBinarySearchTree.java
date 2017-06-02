package com.tfr.collections.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class TestBinarySearchTree {

    @Test
    public void test() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();

        assertTrue(tree.isEmpty());

        tree.add("I");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        tree.add("M");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        tree.add("G");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        tree.add("B");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        tree.add("C");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        tree.add("H");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        tree.add("J");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        tree.add("Q");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        tree.add("R");
        System.out.println(treeToString(tree, iBinarySearchTree.Traversal.PreOrder));

        assertFalse(tree.isEmpty());

        assertEquals(9, tree.getSize());
        assertEquals("I", tree.get("I"));
        assertEquals("M", tree.get("M"));

        assertTrue(tree.contains("B"));
        assertFalse(tree.contains("A"));

        assertEquals("IGBCHMJQR", treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        assertEquals("BCGHIJMQR", treeToString(tree, iBinarySearchTree.Traversal.InOrder));
        assertEquals("CBHGJRQMI", treeToString(tree, iBinarySearchTree.Traversal.PostOrder));

        assertEquals("B", tree.min());
        assertEquals("R", tree.max());

        assertTrue(tree.remove("C"));
        assertFalse(tree.contains("C"));
        assertEquals(8, tree.getSize());

        assertEquals("IGBHMJQR", treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        assertEquals("BGHIJMQR", treeToString(tree, iBinarySearchTree.Traversal.InOrder));
        assertEquals("BHGJRQMI", treeToString(tree, iBinarySearchTree.Traversal.PostOrder));

        assertTrue(tree.remove("Q"));
        assertFalse(tree.contains("Q"));
        assertEquals(7, tree.getSize());

        assertEquals("IGBHMJR", treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        assertEquals("BGHIJMR", treeToString(tree, iBinarySearchTree.Traversal.InOrder));
        assertEquals("BHGJRMI", treeToString(tree, iBinarySearchTree.Traversal.PostOrder));

        assertTrue(tree.remove("G"));
        assertFalse(tree.contains("G"));
        assertEquals(6, tree.getSize());

        assertEquals("IBHMJR", treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        assertEquals("BHIJMR", treeToString(tree, iBinarySearchTree.Traversal.InOrder));
        assertEquals("HBJRMI", treeToString(tree, iBinarySearchTree.Traversal.PostOrder));
    }

    @Test
    public void testBalance() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("A");
        tree.add("B");
        tree.add("C");
        tree.add("D");
        tree.add("E");
        tree.add("F");
        tree.add("G");
        assertEquals("ABCDEFG", treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        assertEquals("ABCDEFG", treeToString(tree, iBinarySearchTree.Traversal.InOrder));
        assertEquals("GFEDCBA", treeToString(tree, iBinarySearchTree.Traversal.PostOrder));
        tree.balance();
        assertEquals("DBACFEG", treeToString(tree, iBinarySearchTree.Traversal.PreOrder));
        assertEquals("ABCDEFG", treeToString(tree, iBinarySearchTree.Traversal.InOrder));
        assertEquals("ACBEGFD", treeToString(tree, iBinarySearchTree.Traversal.PostOrder));
    }

    private String treeToString(BinarySearchTree<String> tree, iBinarySearchTree.Traversal traversal) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = tree.getIterator(traversal);
        while(iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
