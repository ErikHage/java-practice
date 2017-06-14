package com.tfr.collections.priorityQueue;

/**
 *
 * Created by Erik on 6/8/2017.
 */
public interface PriorityQueue<T> {

    void enqueue(T element);

    T dequeue();

    boolean isEmpty();
    boolean isFull();

    int getSize();

}
