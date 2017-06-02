package com.tfr.collections.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * Created by Erik on 6/2/2017.
 */
@SuppressWarnings("unchecked")
public class SortedArrayBasedList<T> implements List<T> {

    protected static final int DEFAULT_CAPACITY = 100;
    protected int numberOfElements = 0;
    protected int originalCapacity;

    protected T[] list;

    protected Comparator<T> comparator;

    public SortedArrayBasedList() {
        //Precondition: T implements Comparable
        this((t1, t2) -> ((Comparable)t1).compareTo(t2));
    }

    public SortedArrayBasedList(Comparator<T> comparator) {
        this(comparator, DEFAULT_CAPACITY);
    }

    public SortedArrayBasedList(Comparator<T> comparator, int capacity) {
        this.comparator = comparator;
        this.list = (T[]) new Object[capacity];
        this.originalCapacity = capacity;
    }

    protected int find(T target) {
        for(int i=0; i<numberOfElements; i++) {
            if(list[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    protected void enlarge() {
        int newLength = list.length + originalCapacity;
        T[] newArray = (T[]) new Object[newLength];
        System.arraycopy(list, 0, newArray, 0, numberOfElements);
        list = newArray;
    }

    @Override
    public boolean add(T element) {
        if(numberOfElements == list.length) {
            enlarge();
        }
        if(numberOfElements == 0) {
            list[0] = element;
        } else {
            for(int i=numberOfElements-1; i>=0; i--) {
                int num = comparator.compare(list[i], element);
                if(num > 0) {
                    list[i+1] = list[i];
                    list[i] = element;
                } else {
                    list[i+1] = element;
                    break;
                }
            }
        }
        numberOfElements++;
        return true;
    }

    @Override
    public T get(T target) {
        return list[find(target)];
    }

    @Override
    public boolean contains(T target) {
        return find(target) > -1;
    }

    @Override
    public boolean remove(T target) {
        return remove(find(target)) != null;
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
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Index based add is not supported");
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Index based set is not supported");
    }

    @Override
    public T get(int index) {
        return list[index];
    }

    @Override
    public int indexOf(T element) {
        return find(element);
    }

    @Override
    public T remove(int index) {
        if(index<0 || index>=numberOfElements) {
            throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to remove method.");
        }
        T hold = list[index];
        for(int i=index+1; i<numberOfElements; i++) {
            list[i-1] = list[i];
        }
        list[numberOfElements-1] = null;
        numberOfElements--;
        return hold;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int previousPosition = -1;

            @Override
            public boolean hasNext() {
                return previousPosition < getSize()-1;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new IndexOutOfBoundsException("Illegal invocation of next in SortedArrayBasedList iterator");
                }
                previousPosition++;
                return list[previousPosition];
            }
        };
    }

    @Override
    public String toString() {
        return "SortedArrayBasedList{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
