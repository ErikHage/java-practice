package com.tfr.collections.list.example;

import com.tfr.collections.linkedlist.DLLNode;

import java.util.Iterator;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class LargeIntList {

    protected DLLNode<Byte> first;
    protected DLLNode<Byte> last;

    protected int numberOfElements;

    public LargeIntList() {
        numberOfElements = 0;
        first = null;
        last = null;
    }

    public int getSize() {
        return numberOfElements;
    }

    public void addFront(Byte element) {
        DLLNode<Byte> newNode = new DLLNode<>(element);
        newNode.setForward(first);
        newNode.setBack(null);
        if(first == null) {
            first = newNode;
            last = newNode;
        } else {
            first.setBack(newNode);
            first = newNode;
        }
        numberOfElements++;
    }

    public void addRear(Byte element) {
        DLLNode<Byte> newNode = new DLLNode<>(element);
        newNode.setForward(null);
        newNode.setBack(last);
        if(first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setForward(newNode);
            last = newNode;
        }
        numberOfElements++;
    }

    public Iterator<Byte> forward() {
        return new Iterator<Byte>() {
            private DLLNode<Byte> next = first;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public Byte next() {
                if(!hasNext()) {
                    throw new IndexOutOfBoundsException("Illegal invocation of next in LargeIntList forward Iterator.");
                }
                Byte hold = next.getInfo();
                next = next.getForward();
                return hold;
            }
        };
    }

    public Iterator<Byte> reverse() {
        return new Iterator<Byte>() {
            private DLLNode<Byte> next = last;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public Byte next() {
                if(!hasNext()) {
                    throw new IndexOutOfBoundsException("Illegal invocation of next in LargeIntList reverse Iterator.");
                }
                Byte hold = next.getInfo();
                next = next.getBack();
                return hold;
            }
        };
    }
}
