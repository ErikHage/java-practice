package com.tfr.collections.stack;

import com.tfr.collections.linkedlist.LLNode;

/**
 * Stack implementation backed by a linked list
 *
 * Created by Erik on 4/28/2017.
 */
public class LinkedStack<T> implements Stack<T> {

    private LLNode<T> top;

    public LinkedStack() {
        top = null;
    }

    @Override
    public void push(T element) throws StackOverflowException {
        LLNode<T> newNode = new LLNode<T>(element);
        newNode.setLink(top);
        top = newNode;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if(isEmpty()) {
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
        T info = top.getInfo();
        top = top.getLink();
        return info;
    }

    @Override
    public T top() throws StackUnderflowException {
        if(isEmpty()) {
            throw new StackUnderflowException("Top attempted on an empty stack.");
        }
        return top.getInfo();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
