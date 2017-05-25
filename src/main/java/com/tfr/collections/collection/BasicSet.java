package com.tfr.collections.collection;

/**
 * Wraps a linked collection and requires uniqueness in its values
 * Created by Erik Hage on 5/25/2017.
 */
public class BasicSet<T> implements Collection<T> {

    protected LinkedCollection<T> set;

    public BasicSet() {
        set = new LinkedCollection<>();
    }

    @Override
    public boolean add(T element) {
        if(!this.contains(element)) {
            set.add(element);
            return true;
        }
        return false;
    }

    @Override
    public T get(T target) {
        return set.get(target);
    }

    @Override
    public boolean contains(T target) {
        return set.contains(target);
    }

    @Override
    public boolean remove(T target) {
        return set.remove(target);
    }

    @Override
    public boolean isFull() {
        return set.isFull();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public int getSize() {
        return set.getSize();
    }
}
