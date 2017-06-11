package com.tfr.collections.graph;

import com.tfr.collections.queue.LinkedQueue;
import com.tfr.collections.queue.Queue;

import java.util.LinkedList;

/**
 *
 * Created by Erik on 6/11/2017.
 */
@SuppressWarnings("unchecked")
public class DirectedAdjacencyGraph<T> implements Graph<T> {

    private static final int DEFAULT_CAPACITY = 50;

    private int numberOfVertices;
    private int maxVertices;

    private T[] vertices;
    private LinkedList[] edges;
    private boolean[] marks;

    public DirectedAdjacencyGraph() {
        this(DEFAULT_CAPACITY);
    }

    public DirectedAdjacencyGraph(int maxVertices) {
        this.numberOfVertices = 0;
        this.maxVertices = maxVertices;
        this.vertices = (T[]) new Object[maxVertices];
        this.marks = new boolean[maxVertices];
        this.edges = new LinkedList[maxVertices];
    }

    @Override
    public boolean isEmpty() {
        return numberOfVertices == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfVertices == maxVertices;
    }

    @Override
    public void addVertex(T vertex) {
        if(isFull()) {
            throw new GraphOverflowException("Cannot add vertex to a full graph");
        }
        vertices[numberOfVertices] = vertex;
        edges[numberOfVertices] = new LinkedList<>();
        numberOfVertices++;
    }

    private int indexIs(T vertex) {
        int index = 0;
        while(!vertex.equals(vertices[index])) {
            index++;
        }
        return index;
    }

    @Override
    public boolean hasVertex(T vertex) {
        for(int i=0; i<numberOfVertices; i++) {
            if(vertices[i].equals(vertex)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addEdge(T fromVertex, T toVertex) {
        int index = indexIs(fromVertex);
        edges[index].add(toVertex);
    }

    @Override
    public Queue<T> getToVertices(T vertex) {
        Queue<T> queue = new LinkedQueue<>();
        int index = indexIs(vertex);
        for(T toVertex : (LinkedList<T>)edges[index]) {
            queue.enqueue(toVertex);
        }
        return queue;
    }

    @Override
    public void clearMarks() {
        marks = new boolean[maxVertices];
    }

    @Override
    public void markVertex(T vertex) {
        int index = indexIs(vertex);
        marks[index] = true;
    }

    @Override
    public boolean isMarked(T vertex) {
        int index = indexIs(vertex);
        return marks[index];
    }

    @Override
    public T getUnmarked() {
        for(int i=0; i<numberOfVertices; i++) {
            if(!marks[i]) {
                return vertices[i];
            }
        }
        return null;
    }

}
