package com.tfr.collections.queue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public interface Queue<T> {

   void enqueue(T element) throws QueueOverflowException;
   T dequeue() throws QueueUnderflowException;

   int getSize();

   boolean isEmpty();
   boolean isFull();

}
