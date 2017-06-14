package com.tfr.collections.priorityQueue;

import com.tfr.collections.queue.QueueOverflowException;
import com.tfr.collections.queue.QueueUnderflowException;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * Created by Erik on 6/14/2017.
 */
@SuppressWarnings("unchecked")
public class HeapPriorityQueue<T> implements PriorityQueue<T> {

    protected ArrayList<T> elements;
    protected int lastIndex;
    protected int maxIndex;

    protected Comparator<T> comparator;

    public HeapPriorityQueue(int maxSize) {
        this(maxSize, (t1, t2) -> ((Comparable)t1).compareTo(t2));
    }

    public HeapPriorityQueue(int maxSize, Comparator<T> comparator) {
        this.elements = new ArrayList<>(maxSize);
        this.lastIndex = -1;
        this.maxIndex = maxSize-1;
        this.comparator = comparator;
    }

    @Override
    public void enqueue(T element) {
        if(lastIndex == maxIndex) {
            throw new QueueOverflowException("HeapPriorityQueue is full");
        }
        lastIndex++;
        elements.add(lastIndex, element);
        reheapUp(element);
    }

    private void reheapUp(T element) {
        int hole = lastIndex;
        int parentIndex = (hole-1)/2;
        while(hole > 0 && comparator.compare(element, elements.get(parentIndex)) > 0) {
            elements.set(hole, elements.get(parentIndex));
            hole = parentIndex;
            parentIndex = (hole-1)/2;
        }
        elements.set(hole, element);
    }

    @Override
    public T dequeue() {
        if(lastIndex == -1) {
            throw new QueueUnderflowException("HeapPriorityQueue is empty");
        }
        T hold = elements.get(0);
        T toMove = elements.remove(lastIndex);

        lastIndex--;
        if(lastIndex != -1) {
            reheapDown(toMove);
        }
        return hold;
    }

    private void reheapDown(T element) {
        int hole = 0;
        int next = newHole(hole, element);

        while(next != hole) {
            elements.set(hole, elements.get(next));
            hole = next;
            next = newHole(hole, element);
        }
        elements.set(hole, element);
    }

    private int newHole(int hole, T element) {
        int left = (hole*2) + 1;
        int right = (hole*2) + 2;

        //hole has no children
        if(left > lastIndex) {
            return hole;
        }
        //hole has left child only
        else if(left == lastIndex) {
            if(comparator.compare(element, elements.get(left)) < 0) { //element < left child
                return left;
            } else { //element >= left child
                return hole;
            }
        }
        //hole has 2 children
        else if(comparator.compare(elements.get(left), elements.get(right)) < 0) {
            if(comparator.compare(elements.get(right), element) <= 0) { //right child <= element
                return hole;
            } else { //element < right child
                return right;
            }
        }
        //left child >= right child
        else if(comparator.compare(elements.get(left), element) <= 0) { //left child <= element
            return hole;
        }
        //element < left child
        else {
            return left;
        }
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public boolean isFull() {
        return lastIndex == maxIndex;
    }

    @Override
    public int getSize() {
        return lastIndex + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HeapPriorityQueue[");
        for(int i=0; i<lastIndex; i++) {
            sb.append(elements.get(i).toString());
            if(i<lastIndex) {
                sb.append(",");
            }
        }
        sb.append("]");
        sb.append("|lastIndex=");
        sb.append(lastIndex);
        sb.append("|maxIndex=");
        sb.append(maxIndex);
        return sb.toString();
    }
}
