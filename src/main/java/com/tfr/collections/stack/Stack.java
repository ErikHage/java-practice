package com.tfr.collections.stack;

/**
 * Stack interface
 *
 * Created by Erik on 4/26/2017.
 */
public interface Stack<T> {

    void push(T element) throws StackOverflowException;

    T pop() throws StackUnderflowException;
    T top() throws StackUnderflowException;

    boolean isFull();
    boolean isEmpty();

}
