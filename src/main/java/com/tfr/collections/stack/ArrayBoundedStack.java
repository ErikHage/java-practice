package com.tfr.collections.stack;

/**
 * Stack implementation backed by an array
 *
 * Created by Erik on 4/28/2017.
 */
@SuppressWarnings(value = "unchecked")
public class ArrayBoundedStack<T> implements Stack<T> {

    private final int DEFAULT_MAX_SIZE = 100;
    private final T[] elements;
    protected int topIndex = -1;

    public ArrayBoundedStack() {
        elements = (T[]) new Object[DEFAULT_MAX_SIZE];
    }

    public ArrayBoundedStack(int maxSize) {
        elements = (T[]) new Object[maxSize];
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if(isFull()) {
            throw new StackOverflowException("Push attempted on a full stack.");
        }
        topIndex++;
        elements[topIndex] = element;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if(isEmpty()) {
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
        T element = elements[topIndex];
        elements[topIndex] = null;
        topIndex--;
        return element;
    }

    @Override
    public T top() throws StackUnderflowException {
        if(isEmpty()) {
            throw new StackUnderflowException("Top attempted on empty stack.");
        }
        return elements[topIndex];
    }

    @Override
    public boolean isFull() {
        return topIndex == (elements.length -1);
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }
}
