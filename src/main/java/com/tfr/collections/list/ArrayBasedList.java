package com.tfr.collections.list;

import java.util.Arrays;
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

    private void enlarge() {
        int newLength = elements.length + originalCapacity;
        T[] newArray = (T[]) new Object[newLength];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    private int find(T element) {
        for(int i=0; i<numberOfElements; i++) {
            if(elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(T element) {
        if(elements.length == numberOfElements) {
            enlarge();
        }
        elements[numberOfElements] = element;
        numberOfElements++;
        return true;
    }

    @Override
    public T get(T target) {
        return elements[find(target)];
    }

    @Override
    public boolean contains(T target) {
        return find(target) > -1;
    }

    @Override
    public boolean remove(T target) {
        int index = find(target);
        return remove(index) != null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public int getSize() {
        return numberOfElements;
    }

    @Override
    public void add(int index, T element) {
        if(index<0 || index>=getSize()) {
            throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to add method.");
        }
        if(elements.length == numberOfElements) {
            enlarge();
        }
        for(int i=numberOfElements; i>index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        numberOfElements++;
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
        if(index<0 || index>=getSize()) {
            throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to get method.");
        }
        return elements[index];
    }

    @Override
    public int indexOf(T element) {
        return find(element);
    }

    @Override
    public T remove(int index) {
        if(index<0 || index>=getSize()) {
            throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to remove method.");
        }
        T hold = elements[index];
        for(int i=index; i<numberOfElements-1; i++) {
            elements[i] = elements[i+1];
        }
        elements[numberOfElements-1] = null;
        numberOfElements--;
        return hold;
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

    @Override
    public String toString() {
        return "ArrayBasedList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
