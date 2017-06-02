package com.tfr.collections.tree;

/**
 * Binary Search Tree Node
 * Created by Erik on 6/1/2017.
 */
public class BSTNode<T> {

    private T info;

    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }
}
