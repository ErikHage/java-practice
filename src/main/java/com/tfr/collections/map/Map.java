package com.tfr.collections.map;

import java.util.Iterator;

/**
 *
 * Created by Erik on 6/8/2017.
 */
public interface Map<K,V> extends Iterable<Entry<K,V>> {

    V put(K key, V value);

    V get(K key);
    V remove(K key);

    boolean contains(K key);

    boolean isFull();
    boolean isEmpty();

    int getSize();

    Iterator<Entry<K,V>> iterator();
}
