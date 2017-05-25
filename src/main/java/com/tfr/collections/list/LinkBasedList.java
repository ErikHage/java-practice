package com.tfr.collections.list;

import com.tfr.collections.linkedlist.LLNode;

import java.util.Iterator;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public class LinkBasedList<T> implements List<T> {

    protected LLNode<T> front;
    protected LLNode<T> rear;
    protected int numberOfElements;

    public LinkBasedList() {
        this.numberOfElements = 0;
        this.front = null;
        this.rear = null;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Illegal index of " + index);
        }
    }

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public T get(T target) {
        return null;
    }

    @Override
    public boolean contains(T target) {
        return false;
    }

    @Override
    public boolean remove(T target) {
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
    public void add(int index, T element) {
        checkIndex(index);
        LLNode<T> newNode = new LLNode<T>(element);

        if(index == 0) {
            if(front == null) {
                front = newNode;
                rear = newNode;
            } else {
                newNode.setLink(front);
                front = newNode;
            }
        } else if(index == getSize()) {
            rear.setLink(newNode);
            rear = newNode;
        } else {
            LLNode<T> node = front;
            for(int i=0; i<index-1; i++) {
                node = node.getLink();
            }
            newNode.setLink(node.getLink());
            node.setLink(newNode);
        }
        numberOfElements++;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        LLNode<T> node = front;
        for(int i=0; i<index; i++) {
            node = node.getLink();
        }
        T hold = node.getInfo();
        node.setInfo(element);
        return hold;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            protected LLNode<T> previousPosition = null;
            protected LLNode<T> currentPosition = null;
            protected LLNode<T> nextPosition = front;

            @Override
            public boolean hasNext() {
                return nextPosition != null;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new IndexOutOfBoundsException("Illegal invocation of next in LinkBasedList Iterator");
                }
                T hold = nextPosition.getInfo();
                if(currentPosition != null) {
                    previousPosition = currentPosition;
                }
                currentPosition = nextPosition;
                nextPosition = nextPosition.getLink();
                return hold;
            }
        };
    }
}
