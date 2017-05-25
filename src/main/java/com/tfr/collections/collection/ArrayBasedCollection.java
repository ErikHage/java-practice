package com.tfr.collections.collection;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
@SuppressWarnings("unchecked")
public class ArrayBasedCollection<T> implements Collection<T> {

    protected static final int DEFAULT_CAPACITY = 100;
    protected T[] elements;
    protected int numberOfElements = 0;

    public ArrayBasedCollection() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBasedCollection(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    protected int find(T target) {
        int location = 0;
        while(location < numberOfElements) {
            if(elements[location].equals(target)) {
                return location;
            } else {
                location++;
            }
        }
        return -1;
    }

    @Override
    public boolean add(T element) {
        if(isFull()) {
            return false;
        }
        elements[numberOfElements] = element;
        numberOfElements++;
        return true;
    }

    @Override
    public T get(T target) {
        int index = find(target);
        if(index > -1) {
            return elements[index];
        }
        return null;
    }

    @Override
    public boolean contains(T target) {
        return find(target) > -1;
    }

    @Override
    public boolean remove(T target) {
        int index = find(target);
        if(index > -1) {
            elements[index] = elements[numberOfElements - 1];
            elements[numberOfElements - 1] = null;
            numberOfElements--;
        }
        return index > -1;
    }

    @Override
    public boolean isFull() {
        return numberOfElements == elements.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public int getSize() {
        return numberOfElements;
    }
}
