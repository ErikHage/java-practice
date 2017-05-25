package com.tfr.collections.list;

import com.tfr.collections.collection.Collection;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public interface List<T> extends Collection<T>, Iterable<T> {

    void add(int index, T element);
    T set(int index, T element);

    T get(int index);
    int indexOf(T element);

    T remove(int index);

}
