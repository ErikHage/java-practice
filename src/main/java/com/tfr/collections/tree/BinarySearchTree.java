package com.tfr.collections.tree;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 *
 * Created by Erik on 6/1/2017.
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<T> implements iBinarySearchTree<T> {

    private BSTNode<T> root;

    private Comparator<T> comparator;

    public BinarySearchTree() {
        this((o1, o2) -> ((Comparable)o1).compareTo(o2));
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public T get(T target) {
        return null;
    }

    @Override
    public boolean contains(T target) {
        return false;
    }

    @Override
    public boolean remove(T target) {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public T min() {
        return null;
    }

    @Override
    public T max() {
        return null;
    }

    @Override
    public Iterator<T> getIterator(Traversal traversal) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
