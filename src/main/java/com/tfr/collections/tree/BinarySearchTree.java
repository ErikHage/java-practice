package com.tfr.collections.tree;

import com.tfr.collections.queue.LinkedQueue;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 *
 * Created by Erik on 6/1/2017.
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<T> implements iBinarySearchTree<T> {

    protected BSTNode<T> root;
    protected Comparator<T> comparator;

    protected boolean found = false;

    public BinarySearchTree() {
        //Precondition: T implements Comparable
        this((o1, o2) -> ((Comparable)o1).compareTo(o2));
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    @Override
    public T min() {
        if(isEmpty()) {
            return null;
        } else {
            BSTNode<T> node = root;
            while(node.getLeft() != null) {
                node = node.getLeft();
            }
            return node.getInfo();
        }
    }

    @Override
    public T max() {
        if(isEmpty()) {
            return null;
        } else {
            BSTNode<T> node = root;
            while(node.getRight() != null) {
                node = node.getRight();
            }
            return node.getInfo();
        }
    }

    @Override
    public boolean add(T element) {
        root = recursiveAdd(element, root);
        return true;
    }

    private BSTNode<T> recursiveAdd(T element, BSTNode<T> node) {
        if(node == null) {
            node = new BSTNode<>(element);
        } else if(comparator.compare(element, node.getInfo()) <= 0) {
            node.setLeft(recursiveAdd(element, node.getLeft()));
        } else {
            node.setRight(recursiveAdd(element, node.getRight()));
        }
        return node;
    }

    @Override
    public T get(T target) {
        return recursiveGet(target, root);
    }

    private T recursiveGet(T target, BSTNode<T> node) {
        if(node == null) {
            return null;
        } else if(comparator.compare(target, node.getInfo()) < 0) {
            return recursiveGet(target, node.getLeft());
        } else if(comparator.compare(target, node.getInfo()) > 0) {
            return recursiveGet(target, node.getRight());
        } else {
            return node.getInfo();
        }
    }

    @Override
    public boolean contains(T target) {
        return recursiveContains(target, root);
    }

    private boolean recursiveContains(T target, BSTNode<T> node) {
        if(node == null) {
            return false;
        } else if(comparator.compare(target, node.getInfo()) < 0) {
            return recursiveContains(target, node.getLeft());
        } else if(comparator.compare(target, node.getInfo()) > 0) {
            return recursiveContains(target, node.getRight());
        } else {
            return true;
        }
    }

    @Override
    public boolean remove(T target) {
        root = recursiveRemove(target, root);
        return found;
    }

    private BSTNode<T> recursiveRemove(T target, BSTNode<T> node) {
        if(node == null) {
            found = false;
        } else if(comparator.compare(target, node.getInfo()) < 0) {
            node.setLeft(recursiveRemove(target, node.getLeft()));
        } else if(comparator.compare(target, node.getInfo()) > 0) {
            node.setRight(recursiveRemove(target, node.getRight()));
        } else {
            node = removeNode(node);
            found = true;
        }
        return node;
    }

    private BSTNode<T> removeNode(BSTNode<T> node) {
        T data;
        if(node.getLeft() == null) {
            return node.getRight();
        } else if(node.getRight() == null) {
            return node.getLeft();
        } else {
            data = getLogicalPredecessor(node.getLeft());
            node.setInfo(data);
            node.setLeft(recursiveRemove(data, node.getLeft()));
            return node;
        }
    }

    private T getLogicalPredecessor(BSTNode<T> subtree) {
        BSTNode<T> temp = subtree;
        while(temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getInfo();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getSize() {
        return recursiveSize(root);
    }

    private int recursiveSize(BSTNode<T> node) {
        if(node == null) {
            return 0;
        }
        return recursiveSize(node.getLeft()) + recursiveSize(node.getRight()) + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return getIterator(Traversal.InOrder);
    }

    @Override
    public Iterator<T> getIterator(Traversal orderType) {
        final LinkedQueue<T> infoQueue = new LinkedQueue<>();

        if(orderType == Traversal.PreOrder) {
            preOrder(root, infoQueue);
        } else if(orderType == Traversal.InOrder) {
            inOrder(root, infoQueue);
        } else if(orderType == Traversal.PostOrder) {
            postOrder(root, infoQueue);
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !infoQueue.isEmpty();
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new IndexOutOfBoundsException("Illegal invocation of next in BinarySearchTree iterator");
                }
                return infoQueue.dequeue();
            }
        };
    }

    private void inOrder(BSTNode<T> node, LinkedQueue<T> queue) {
        if(node != null) {
            inOrder(node.getLeft(), queue);
            queue.enqueue(node.getInfo());
            inOrder(node.getRight(), queue);
        }
    }

    private void preOrder(BSTNode<T> node, LinkedQueue<T> queue) {
        if(node != null) {
            queue.enqueue(node.getInfo());
            preOrder(node.getLeft(), queue);
            preOrder(node.getRight(), queue);
        }
    }

    private void postOrder(BSTNode<T> node, LinkedQueue<T> queue) {
        if(node != null) {
            postOrder(node.getLeft(), queue);
            postOrder(node.getRight(), queue);
            queue.enqueue(node.getInfo());
        }
    }

    public void balance() {
        Iterator<T> iterator = getIterator(Traversal.InOrder);
        int index = 0;
        T[] elements = (T[]) new Object[getSize()];
        while(iterator.hasNext()) {
            elements[index] = iterator.next();
            index++;
        }
        root = null;
        insertTree(elements, 0, index-1);
    }

    private void insertTree(T[] elements, int low, int high) {
        if(low == high) {
            add(elements[low]);
        } else if(low+1 == high) {
            add(elements[low]);
            add(elements[high]);
        } else {
            int mid = (low + high) /2;
            add(elements[mid]);
            insertTree(elements, low, mid-1);
            insertTree(elements, mid+1, high);
        }
    }
}
