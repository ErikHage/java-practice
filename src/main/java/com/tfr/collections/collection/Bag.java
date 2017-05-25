package com.tfr.collections.collection;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public interface Bag<T> {

    T grab(); //random element
    int count(T target); //number of equivalent elements to target
    int removeAll(T target); //remove all equivalent elements to target
    void clear();


}
