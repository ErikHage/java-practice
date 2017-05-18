package com.tfr.collections.queue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public interface Dequeue<T> {

    void enqueueFront(T element);
    void enqueueRear(T element);

    T dequeueFront();
    T dequeueRear();

    boolean isEmpty();
    boolean isFull();

    int getSize();
}
