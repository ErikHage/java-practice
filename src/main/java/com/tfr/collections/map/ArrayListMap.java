package com.tfr.collections.map;

import java.util.Iterator;

/**
 *
 * Created by Erik on 6/8/2017.
 */
public class ArrayListMap<K,V> implements Map<K,V> {

    protected static final int DEFAULT_CAPACITY = 100;

    protected Entry[] map;
    protected int originalCapacity;
    protected int numberOfElements;

    public ArrayListMap() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListMap(int capacity) {
        this.map = new Entry[capacity];
        this.originalCapacity = capacity;
        this.numberOfElements = 0;
    }

    private void enlarge() {

    }

    @Override
    public V put(K key, V value) {
        if(key == null) {
            throw new IllegalArgumentException("Map does not support null keys");
        }
        return null;
    }

    @Override
    public V get(K key) {
        if(key == null) {
            throw new IllegalArgumentException("Map does not support null keys");
        }
        return null;
    }

    @Override
    public V remove(K key) {
        if(key == null) {
            throw new IllegalArgumentException("Map does not support null keys");
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        if(key == null) {
            throw new IllegalArgumentException("Map does not support null keys");
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public int getSize() {
        return numberOfElements;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return null;
    }
}
