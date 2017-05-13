package com.tfr.collections.linkedlist;

/**
 * Implementation of a linked list
 *
 * Created by Erik on 4/28/2017.
 */
public class LinkedList<T> {

    private LLNode<T> head;

    public LinkedList() {
        head = null;
    }

    public void print() {
        print(head);
    }

    private void print(LLNode<T> llNode) {
        if(llNode != null) {
            System.out.println(llNode.getInfo());
            print(llNode.getLink());
        }
    }

    public void printRev() {
        printRev(head);
    }

    private void printRev(LLNode<T> llNode) {
        if(llNode != null) {
            printRev(llNode.getLink());
            System.out.println(llNode.getInfo());
        }
    }

    public int getSize() {
        return getSize(head);
    }

    private int getSize(LLNode<T> llNode) {
        return llNode == null
                ? 0
                : 1 + getSize(llNode.getLink());
    }

    public T getFirst() {
        return head.getInfo();
    }

    public T getLast() {
        return getLastNode().getInfo();
    }

    private LLNode<T> getLastNode() {
        LLNode<T> current = head;
        while(current.getLink() != null) {
            current = current.getLink();
        }
        return current;
    }

    public void add(T info) {
        LLNode<T> newNode = new LLNode<T>(info);
        if(head == null) {
            head = newNode;
        } else {
            getLastNode().setLink(newNode);
        }
    }


}
