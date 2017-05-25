package com.tfr.collections.collection;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public interface Collection<T> {

    boolean add(T element);

    T get(T target);

    boolean contains(T target);

    boolean remove(T target);

    boolean isFull();

    boolean isEmpty();

    int getSize();

}
