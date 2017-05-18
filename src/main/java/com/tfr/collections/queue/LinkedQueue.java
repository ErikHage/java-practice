package com.tfr.collections.queue;

import com.tfr.collections.linkedlist.LLNode;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class LinkedQueue<T> implements Queue<T> {

    protected LLNode<T> front;
    protected LLNode<T> rear;
    protected int numberOfElements = 0;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        LLNode<T> newNode = new LLNode<>(element);
        if(rear == null) {
            front = newNode;
        } else {
            rear.setLink(newNode);
        }
        rear = newNode;
        numberOfElements++;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if(front == null) {
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        }
        T element = front.getInfo();
        front = front.getLink();
        if(front == null) {
            rear = null;
        }
        numberOfElements--;
        return element;
    }

    @Override
    public int getSize() {
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
