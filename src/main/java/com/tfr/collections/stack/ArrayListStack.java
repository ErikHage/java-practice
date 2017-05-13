package com.tfr.collections.stack;

import java.util.ArrayList;

/**
 * Stack implementation backed by an ArrayList
 *
 * Created by Erik on 4/28/2017.
 */
public class ArrayListStack<T> implements Stack<T> {

    private final ArrayList<T> elements;

    public ArrayListStack() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void push(T element) throws StackOverflowException {
        elements.add(element);
    }

    @Override
    public T pop() throws StackUnderflowException {
        if(isEmpty()) {
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
        return elements.remove(elements.size()-1);
    }

    @Override
    public T top() throws StackUnderflowException {
        if(isEmpty()) {
            throw new StackUnderflowException("Top attempted on an empty stack.");
        }
        return elements.get(elements.size()-1);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return elements.size() == 0;
    }
}
