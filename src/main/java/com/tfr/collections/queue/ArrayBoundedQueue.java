package com.tfr.collections.queue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
@SuppressWarnings("unchecked")
public class ArrayBoundedQueue<T> implements Queue<T> {

    protected static final int DEFAULT_CAPACITY = 100;
    protected T[] elements;
    protected int numberOfElements = 0;
    protected int front = 0;
    protected int rear;

    public ArrayBoundedQueue() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        rear = DEFAULT_CAPACITY - 1;
    }

    public ArrayBoundedQueue(int maxSize) {
        elements = (T[]) new Object[maxSize];
        rear = maxSize - 1;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if(isFull()) {
            throw new QueueOverflowException("Enqueue attempted on full queue.");
        }
        rear = (rear +1) % elements.length;
        elements[rear] = element;
        numberOfElements++;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()) {
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        }
        T toReturn = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        numberOfElements--;
        return toReturn;
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
        return numberOfElements == elements.length;
    }
}
