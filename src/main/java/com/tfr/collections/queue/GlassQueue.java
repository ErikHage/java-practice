package com.tfr.collections.queue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public interface GlassQueue<T> extends Queue<T>{

    T peekFront();
    T peekRear();

}
