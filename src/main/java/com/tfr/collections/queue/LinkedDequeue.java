package com.tfr.collections.queue;

import com.tfr.collections.linkedlist.DLLNode;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class LinkedDequeue<T> implements Dequeue<T> {

    protected DLLNode<T> front;
    protected DLLNode<T> rear;

    protected int numberOfElements = 0;

    public LinkedDequeue() {
        front = null;
        rear = null;
    }

    @Override
    public void enqueueFront(T element) {
        DLLNode<T> newNode = new DLLNode<>(element);
        if(front == null) {
            newNode.setForward(newNode);
            newNode.setBack(newNode);
            front = newNode;
            rear = newNode;
        } else {
            newNode.setForward(front);
            front = newNode;
        }
        numberOfElements++;
    }

    @Override
    public void enqueueRear(T element) {
        DLLNode<T> newNode = new DLLNode<>(element);
        if(rear == null) {
            newNode.setForward(newNode);
            newNode.setBack(newNode);
            front = newNode;
            rear = newNode;
        } else {
            newNode.setBack(rear);
            rear = newNode;
        }
        numberOfElements++;
    }

    @Override
    public T dequeueFront() {
        if(front == null) {
            throw new QueueUnderflowException("Dequeue attempted on an empty queue.");
        }
        T element = front.getInfo();
        if(front.getForward() == null) {
            front = null;
            rear = null;
        } else {
            front.getForward().setBack(null);
            front = front.getForward();
        }
        numberOfElements--;
        return element;
    }

    @Override
    public T dequeueRear() {
        if(rear == null) {
            throw new QueueUnderflowException("Dequeue attempted on an empty queue.");
        }
        T element = rear.getInfo();
        if(rear.getBack() == null) {
            front = null;
            rear = null;
        } else {
            rear.getBack().setForward(null);
            rear = rear.getBack();
        }
        numberOfElements--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getSize() {
        return numberOfElements;
    }
}
