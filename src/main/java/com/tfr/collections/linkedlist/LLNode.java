package com.tfr.collections.linkedlist;

/**
 * A node in a Linked List
 *
 * Created by Erik on 4/28/2017.
 */
public class LLNode<T> {

    protected T info;
    protected LLNode<T> link;

    public LLNode(T info) {
        this.info = info;
        this.link = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public LLNode<T> getLink() {
        return link;
    }

    public void setLink(LLNode<T> link) {
        this.link = link;
    }
}
