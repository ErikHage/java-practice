package com.tfr.collections.linkedlist;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class DLLNode<T> {

    private T info;

    private DLLNode<T> forward;
    private DLLNode<T> back;

    public DLLNode(T info) {
        this.info = info;
        this.forward = null;
        this.back = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public DLLNode<T> getForward() {
        return forward;
    }

    public void setForward(DLLNode<T> forward) {
        this.forward = forward;
    }

    public DLLNode<T> getBack() {
        return back;
    }

    public void setBack(DLLNode<T> back) {
        this.back = back;
    }
}
