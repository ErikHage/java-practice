package com.tfr.collections.list;

import java.util.Iterator;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
@SuppressWarnings("unchecked")
public class ArrayBasedList<T> implements List<T> {

    protected static final int DEFAULT_CAPACITY = 100;
    protected int originalCapacity;
    protected T[] elements;
    protected int numberOfElements;

    public ArrayBasedList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBasedList(int capacity) {
        this.originalCapacity = capacity;
        this.numberOfElements = 0;
        this.elements = (T[]) new Object[capacity];
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
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T set(int index, T element) {
        if(index<0 || index>=getSize()) {
            throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to set method.");
        }
        T hold = elements[index];
        elements[index] = element;
        return hold;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int previousPosition = -1;

            @Override
            public boolean hasNext() {
                return previousPosition < getSize()-1;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new IndexOutOfBoundsException("Illegal invocation of next() in ArrayBasedList Iterator");
                }
                previousPosition++;
                return elements[previousPosition];
            }
        };
    }

    private void enlarge() {

    }

    private int find(T element) {
        return 0;
    }
}
