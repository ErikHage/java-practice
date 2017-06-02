package com.tfr.collections.tree;

import com.tfr.collections.collection.Collection;

import java.util.Iterator;

/**
 *
 * Created by Erik on 6/1/2017.
 */
public interface iBinarySearchTree<T> extends Collection<T>, Iterable<T> {

    enum Traversal {
        PreOrder,
        InOrder,
        PostOrder
    }

    T min();
    T max();

    Iterator<T> getIterator(Traversal traversal);

}