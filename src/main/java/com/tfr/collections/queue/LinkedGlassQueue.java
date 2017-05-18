package com.tfr.collections.queue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class LinkedGlassQueue<T> extends LinkedQueue<T> implements GlassQueue<T> {

    public LinkedGlassQueue() {
        super();
    }

    @Override
    public T peekFront() {
        if(isEmpty()) {
            return null;
        }
        return front.getInfo();
    }

    @Override
    public T peekRear() {
        if(isEmpty()) {
            return null;
        }
        return rear.getInfo();
    }
}
