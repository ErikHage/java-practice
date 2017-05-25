package com.tfr.collections.collection;

import com.tfr.collections.linkedlist.LLNode;
import com.tfr.collections.support.Duo;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public class LinkedCollection<T> implements Collection<T> {

    protected LLNode<T> head;
    protected int numberOfElements = 0;

    public LinkedCollection() {
        this.head = null;
    }

    protected Duo<LLNode<T>, LLNode<T>> find(T element) {
        Duo<LLNode<T>, LLNode<T>> response = new Duo<>();
        LLNode<T> current = head;
        LLNode<T> previous = null;

        while(current != null) {
            if(current.getInfo().equals(element)) {
                break;
            }
            previous = current;
            current = current.getLink();
        }

        response.setA(current);
        response.setB(previous);
        return response;
    }

    @Override
    public boolean add(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        newNode.setLink(head);
        head = newNode;
        numberOfElements++;
        return true;
    }

    @Override
    public T get(T target) {
        LLNode<T> node = find(target).getA();
        if(node != null) {
            return node.getInfo();
        }
        return null;
    }

    @Override
    public boolean contains(T target) {
        LLNode<T> node = find(target).getA();
        return node != null;
    }

    @Override
    public boolean remove(T target) {
        Duo<LLNode<T>, LLNode<T>> response = find(target);
        LLNode<T> current = response.getA();
        LLNode<T> previous = response.getB();

        if(current == null) {
            return false;
        }

        if(previous == null) {
            current = current.getLink();
        } else {
            previous.setLink(current.getLink());
            current = null;
        }
        numberOfElements--;
        return true;
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
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedCollection: ");
        LLNode<T> current = head;

        while(current != null) {
            sb.append(current.getInfo().toString());
            current = current.getLink();
            if(current != null) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
