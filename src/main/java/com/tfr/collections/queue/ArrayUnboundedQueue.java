package com.tfr.collections.queue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
@SuppressWarnings("unchecked")
public class ArrayUnboundedQueue<T> implements Queue<T> {

    protected static final int DEFAULT_CAPACITY = 100;
    protected T[] elements;
    protected int originalCapacity;
    protected int numberOfElements = 0;
    protected int front = 0;
    protected int rear;

    public ArrayUnboundedQueue() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        rear = DEFAULT_CAPACITY - 1;
        this.originalCapacity = DEFAULT_CAPACITY;
    }

    public ArrayUnboundedQueue(final int originalCapacity) {
        elements = (T[]) new Object[originalCapacity];
        rear = originalCapacity - 1;
        this.originalCapacity = originalCapacity;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if(numberOfElements == elements.length) {
            enlarge();
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        numberOfElements++;
    }

    private void enlarge() {
        T[] larger = (T[]) new Object[elements.length + originalCapacity];

        int currentSmaller = front;
        for(int currentLarger = 0; currentLarger < numberOfElements; currentLarger++) {
            larger[currentLarger] = elements[currentSmaller];
            currentSmaller = (currentSmaller + 1) % elements.length;
        }

        elements = larger;
        front = 0;
        rear = numberOfElements - 1;
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
        return false;
    }
}
