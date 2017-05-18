package com.tfr.collections.queue;

import com.tfr.collections.linkedlist.LLNode;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class CircularLinkedQueue<T> implements Queue<T> {

    protected LLNode<T> rear;
    protected int numberOfElements = 0;

    public CircularLinkedQueue() {
        rear = null;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        LLNode<T> newNode = new LLNode<>(element);
        LLNode<T> front = null;
        if(rear != null) {
            front = rear.getLink();
            newNode.setLink(front);
            rear.setLink(newNode);
            rear = newNode;
        } else {
            rear = newNode;
            rear.setLink(newNode);
        }
        numberOfElements++;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if(rear == null) {
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        }
        LLNode<T> front = rear.getLink();
        T element = front.getInfo();
        if(numberOfElements == 1) {
            rear = null;
        } else {
            rear.setLink(front.getLink());
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
